package com.g2inc.scap.library.domain.oval.oval59;
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

import org.jdom.Document;

import com.g2inc.scap.library.domain.SCAPDocumentTypeEnum;
import com.g2inc.scap.library.domain.oval.AffectedItemFamilyEnum;
import com.g2inc.scap.library.domain.oval.OvalFunctionEnum;
import com.g2inc.scap.library.domain.oval.OvalTest;
import com.g2inc.scap.library.domain.oval.impl.DefinitionsDocumentBase;
import com.g2inc.scap.library.domain.oval.impl.OvalTestMultiStateImpl;
import com.g2inc.scap.library.schema.NameDoc;
import java.util.List;

/**
 * Implementation of an OVALDefinitionsDocument for OVAL 5.9
 *
 */
public class DefinitionsDocumentImpl extends DefinitionsDocumentBase
{
    private static final OvalFunctionEnum[] validFunctions = {OvalFunctionEnum.arithmetic, OvalFunctionEnum.begin, OvalFunctionEnum.concat,
        OvalFunctionEnum.end, OvalFunctionEnum.escape_regex, OvalFunctionEnum.split, OvalFunctionEnum.substring,
        OvalFunctionEnum.time_difference, OvalFunctionEnum.regex_capture};
    
	private static final AffectedItemFamilyEnum [] supportedAffectedFamilies = 
		{
		AffectedItemFamilyEnum.catos,
		AffectedItemFamilyEnum.ios,
		AffectedItemFamilyEnum.macos,
		AffectedItemFamilyEnum.pixos,
		AffectedItemFamilyEnum.undefined,
		AffectedItemFamilyEnum.unix,
		AffectedItemFamilyEnum.vmware_infrastructure,
		AffectedItemFamilyEnum.windows
		};
	
	public DefinitionsDocumentImpl(Document doc) {
            super(doc);
            setDocumentType(SCAPDocumentTypeEnum.OVAL_59);
	}
	
	@Override
	public OvalTest getTestWrapper() {
		return new OvalTestMultiStateImpl(this);
	}
	
	@Override
	public AffectedItemFamilyEnum[] getSupportedFamilies() {
		return supportedAffectedFamilies;
	}
    
    @Override
    public OvalFunctionEnum[] getValidFunctions() {
        return validFunctions;
    }
    
    @Override
    public List<NameDoc> getDataTypeEnumerations() {
    	return getEnumerationValues("SimpleDatatypeEnumeration");
    }
	
}
