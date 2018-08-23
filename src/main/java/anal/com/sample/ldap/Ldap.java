package anal.com.sample.ldap;

import java.io.IOException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;




public class Ldap
{
	static String ldapURL;
	private static final String MEMBER_OF = "memberOf";
	private static final String[] attrIdsToSearch = new String[] { MEMBER_OF };
	public static final String SEARCH_BY_SAM_ACCOUNT_NAME = "(sAMAccountName=%s)";
	public static final String SEARCH_GROUP_BY_GROUP_CN = "(&(objectCategory=group)(cn={0}))";
	String memberof = null;
	String userBase =null;
	String dn =null;
	
	Hashtable<String, String> env = new Hashtable<String, String>();
	IniReadWrite ini = new IniReadWrite();
	
	
	
	
public boolean Login(String username,String password, String memberOF) {
			
	
		
	// ###############  INI FILE ##############	
				
		try
		{
			
			userBase = ini.get("LDAP", "userBase");
		    dn= ini.get("LDAP", "dn");
		    ldapURL = "ldap://"+ini.get("LDAP", "server_ip") +":389";
		    memberof = "CN="+memberOF+","+ ini.get("LDAP", "GroupCN")+","+userBase ;

		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		    env.put(Context.PROVIDER_URL, ldapURL);
		    env.put(Context.SECURITY_PRINCIPAL, username+dn);
		    env.put(Context.SECURITY_CREDENTIALS, password);
		    env.put(Context.SECURITY_AUTHENTICATION, "simple");
		    InitialDirContext context;
			try
			{
				context = new InitialDirContext(env);
			    String filter  = String.format(SEARCH_BY_SAM_ACCOUNT_NAME, username);
			    SearchControls constraints = new SearchControls();
			    constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			    constraints.setReturningAttributes(attrIdsToSearch);
			    NamingEnumeration results = context.search(userBase, filter,constraints);
				SearchResult result = (SearchResult) results.next();
			    NameParser parser = context.getNameParser("");
		//	    Name contextName = parser.parse(context.getNameInNamespace());
		//	    Name baseName = parser.parse(userBase);
		//	    Name entryName = parser.parse(new CompositeName(result.getName()).get(0));
			    Attributes attrs = result.getAttributes();
			    Attribute attr = attrs.get(attrIdsToSearch[0]);
			    NamingEnumeration e = attr.getAll();
			
			    while (e.hasMore()) {
			    		String value = (String) e.next();
			    			if (value.equals(memberof))
			    				{
			    				System.out.println("success");
			    					return true;
			    					
			    					
			    				}
			   }
			
			} catch (NamingException e)
			{
			
			}
			System.out.println("Error");
	return false;
		 }
	

}
