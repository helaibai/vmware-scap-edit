package com.g2inc.scap.editor.gui.model.tree.stream;
/* ESCAPE Software Copyright 2010 G2, Inc. - All rights reserved.
*
* ESCAPE is open source software distributed under GNU General Public License Version 3.  ESCAPE is not in the public domain 
* and G2, Inc. holds its copyright.  Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:

* 1. Redistributions of ESCAPE source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
* 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the ESCAPE Software distribution. 
* 3. Neither the name of G2, Inc. nor the names of any contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
* INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
* IN NO EVENT SHALL G2, INC., THE AUTHORS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
* OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
* OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.

* You should have received a copy of the GNU General Public License Version 3 along with this program. 
* If not, see http://www.gnu.org/licenses/ for a copy.
*/

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.log4j.Logger;

import com.g2inc.scap.editor.gui.resources.EditorMessages;
import com.g2inc.scap.library.domain.SCAPDocument;
import com.g2inc.scap.library.domain.datastream.DataStream;
import com.g2inc.scap.library.domain.scap12.Scap12DataStreamCollection;

public class SCAPStreamTreeModel extends DefaultTreeModel
{

    private static final long serialVersionUID = 1L;
    public static final String NODE_BUNDLE = EditorMessages.SCAP + " Stream";
    public static final String NODE_DOCUMENTS = "Documents";

    private static final Logger log = Logger.getLogger(SCAPStreamTreeModel.class);
    private Scap12DataStreamCollection doc = null;
    private String filterString = null;

    public SCAPStreamTreeModel(Scap12DataStreamCollection dsc, String filterString)
    {
        super(new DefaultMutableTreeNode("No Document Loaded"));

        this.filterString = filterString;

        if (dsc != null)
        {
            this.doc = dsc;

            DefaultMutableTreeNode ourRoot = (DefaultMutableTreeNode) getRoot();
            ourRoot.setUserObject(dsc);


            // Iterating each data stream as it may contain many
            List<DataStream> dataStreamList = dsc.getDataStreamCollection().getDataStream();
            
            for (DataStream dataStream : dataStreamList) {

                // Adding this stream to the nodes
                DefaultMutableTreeNode streamNode = new DefaultMutableTreeNode(dataStream);

                ourRoot.add(streamNode);
                
                addNewList("Checklists", dsc.getChecklists(dataStream), streamNode);
                
                addNewList("Checks", dsc.getChecks(dataStream), streamNode);
                
                addNewList("Dictionaries", dsc.getDictionaries(dataStream), streamNode);
                
                addNewList("Extended Components", dsc.getExtendedComponents(dataStream), streamNode);

            }
                
        }
    }
    
    
    private void addNewList(String title, List<SCAPDocument> docList, DefaultMutableTreeNode streamNode) {
        
        if(docList != null && docList.size() > 0)
        {
            DefaultMutableTreeNode listNode = new DefaultMutableTreeNode(title);
            streamNode.add(listNode);

            for(SCAPDocument scapDoc : docList) {
                DefaultMutableTreeNode bmNode = new DefaultMutableTreeNode(scapDoc);
                listNode.add(bmNode);
            }
        }
    }
    

    @Override
    public Object getRoot()
    {
        return root;
    }

    public String getFilterString()
    {
        return filterString;
    }

    public void setFilterString(String filterString)
    {
        this.filterString = filterString;

    }
}
