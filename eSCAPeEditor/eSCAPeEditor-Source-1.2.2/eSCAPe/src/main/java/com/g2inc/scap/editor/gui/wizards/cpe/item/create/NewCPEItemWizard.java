package com.g2inc.scap.editor.gui.wizards.cpe.item.create;
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

import com.g2inc.scap.editor.gui.resources.EditorMessages;
import com.g2inc.scap.editor.gui.windows.EditorMainWindow;
import com.g2inc.scap.editor.gui.wizards.Wizard;
import com.g2inc.scap.library.domain.cpe.CPEDictionaryDocument;
import com.g2inc.scap.library.domain.cpe.CPEItem;

public class NewCPEItemWizard extends Wizard
{
    private EditorMainWindow parentWin = null;
    private CPEDictionaryDocument dictDoc = null;
    private CPEItem item = null;

    private NewCPEItemWizardPage page = null;

    private void addPages()
    {
        page = new NewCPEItemWizardPage(this);
        page.setData(dictDoc);
        
        addWizardPage(page);
    }

    public NewCPEItemWizard(java.awt.Frame parent, boolean modal, CPEDictionaryDocument cdd)
    {
        super(parent, modal);
        setTitle("Create new " + EditorMessages.CPE + " Item");
        parentWin = (EditorMainWindow) parent;
        
        dictDoc = cdd;
        item = cdd.createItem();

        addPages();
    }

    public CPEDictionaryDocument getOvalDefDoc()
    {
        return dictDoc;
    }

    public CPEItem getItem()
    {
        return item;
    }

    public EditorMainWindow getParentWin()
    {
        return parentWin;
    }

    public void setParentWin(EditorMainWindow parentWin)
    {
        this.parentWin = parentWin;
    }

    @Override
    public void performFinish()
    {
        item.setTitle(page.getItemTitle());
        item.setName(page.getItemName());
    }
}
