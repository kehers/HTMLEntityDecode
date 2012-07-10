import java.util.Enumeration;
import java.util.Hashtable;

public class HTML {

    static String [] constMappingTable = {"HTML_SPECIALCHARS", "HTML_ENTITIES"};
    static String [] constMappingQuoteStyle = {"ENT_NOQUOTES", "ENT_COMPAT", "ENT_QUOTES"};
    
    public static String htmlEntityDecode (String string, String quoteStyle) {
    	
        Hashtable hashMap = getHtmlTranslationTable("HTML_ENTITIES", quoteStyle);
        /*if (false === (hash_map = this.get_html_translation_table('HTML_ENTITIES', quote_style))) {
            return false;
        }//*/

        hashMap.put("&", "&amp;");

        Enumeration e = hashMap.keys();
        while(e.hasMoreElements())
        {
            String symbol = (String) e.nextElement();
        	String entity = (String) hashMap.get(symbol);

        	string = replace(string, entity, symbol);
        }
        
        return replace(string, "&#039;", "'");
    }
	
    public static Hashtable getHtmlTranslationTable (String table, String quoteStyle) {
        String [] entities = new String[255];
        Hashtable hashMap = new Hashtable();

        String useTable = table.equals("") ? table.toUpperCase() : "HTML_SPECIALCHARS";
        String useQuoteStyle = quoteStyle.equals("") ? quoteStyle.toUpperCase() : "ENT_COMPAT";

        if (!useTable.equals("HTML_SPECIALCHARS") && !useTable.equals("HTML_ENTITIES")) {
            //throw new Error("Table: " + useTable + " not supported");
            return hashMap;
        }

        entities[38] = "&amp;";
        if (useTable.equals("HTML_ENTITIES")) {
            entities[160] = "&nbsp;";
            entities[161] = "&iexcl;";
            entities[162] = "&cent;";
            entities[163] = "&pound;";
            entities[164] = "&curren;";
            entities[165] = "&yen;";
            entities[166] = "&brvbar;";
            entities[167] = "&sect;";
            entities[168] = "&uml;";
            entities[169] = "&copy;";
            entities[170] = "&ordf;";
            entities[171] = "&laquo;";
            entities[172] = "&not;";
            entities[173] = "&shy;";
            entities[174] = "&reg;";
            entities[175] = "&macr;";
            entities[176] = "&deg;";
            entities[177] = "&plusmn;";
            entities[178] = "&sup2;";
            entities[179] = "&sup3;";
            entities[180] = "&acute;";
            entities[181] = "&micro;";
            entities[182] = "&para;";
            entities[183] = "&middot;";
            entities[184] = "&cedil;";
            entities[185] = "&sup1;";
            entities[186] = "&ordm;";
            entities[187] = "&raquo;";
            entities[188] = "&frac14;";
            entities[189] = "&frac12;";
            entities[190] = "&frac34;";
            entities[191] = "&iquest;";
            entities[192] = "&Agrave;";
            entities[193] = "&Aacute;";
            entities[194] = "&Acirc;";
            entities[195] = "&Atilde;";
            entities[196] = "&Auml;";
            entities[197] = "&Aring;";
            entities[198] = "&AElig;";
            entities[199] = "&Ccedil;";
            entities[200] = "&Egrave;";
            entities[201] = "&Eacute;";
            entities[202] = "&Ecirc;";
            entities[203] = "&Euml;";
            entities[204] = "&Igrave;";
            entities[205] = "&Iacute;";
            entities[206] = "&Icirc;";
            entities[207] = "&Iuml;";
            entities[208] = "&ETH;";
            entities[209] = "&Ntilde;";
            entities[210] = "&Ograve;";
            entities[211] = "&Oacute;";
            entities[212] = "&Ocirc;";
            entities[213] = "&Otilde;";
            entities[214] = "&Ouml;";
            entities[215] = "&times;";
            entities[216] = "&Oslash;";
            entities[217] = "&Ugrave;";
            entities[218] = "&Uacute;";
            entities[219] = "&Ucirc;";
            entities[220] = "&Uuml;";
            entities[221] = "&Yacute;";
            entities[222] = "&THORN;";
            entities[223] = "&szlig;";
            entities[224] = "&agrave;";
            entities[225] = "&aacute;";
            entities[226] = "&acirc;";
            entities[227] = "&atilde;";
            entities[228] = "&auml;";
            entities[229] = "&aring;";
            entities[230] = "&aelig;";
            entities[231] = "&ccedil;";
            entities[232] = "&egrave;";
            entities[233] = "&eacute;";
            entities[234] = "&ecirc;";
            entities[235] = "&euml;";
            entities[236] = "&igrave;";
            entities[237] = "&iacute;";
            entities[238] = "&icirc;";
            entities[239] = "&iuml;";
            entities[240] = "&eth;";
            entities[241] = "&ntilde;";
            entities[242] = "&ograve;";
            entities[243] = "&oacute;";
            entities[244] = "&ocirc;";
            entities[245] = "&otilde;";
            entities[246] = "&ouml;";
            entities[247] = "&divide;";
            entities[248] = "&oslash;";
            entities[249] = "&ugrave;";
            entities[250] = "&uacute;";
            entities[251] = "&ucirc;";
            entities[252] = "&uuml;";
            entities[253] = "&yacute;";
            entities[254] = "&thorn;";
            entities[255] = "&yuml;";
        }

        if (!useQuoteStyle.equals("ENT_NOQUOTES")) {
            entities[34] = "&quot;";
        }
        if (useQuoteStyle.equals("ENT_QUOTES")) {
            entities[39] = "&#39;";
        }
        entities[60] = "&lt;";
        entities[62] = "&gt;";


        // ascii decimals to real symbols
        for (int i=0;i<entities.length;i++) {
            if (entities[i] != null) {
                    String key = String.valueOf((char) i);
                    //System.out.println(key+" "+entities[i]);
                    hashMap.put(key, entities[i]);
            }
        }

        return hashMap;
    }
	
    private static String replace(String s, String f, String r) {
        if (s == null)  return s;

        if (f == null)  return s;

        if(r == null)   r = "";

        int index01 = s.indexOf(f);
        while(index01 != -1)
        {
            s = s.substring(0, index01) + r + s.substring(index01 + f.length());
            index01 += r.length();
            index01 = s.indexOf(f, index01);
        }
        return s;
    }
}
