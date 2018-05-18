package com.vaibhav.ldap;

import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

public class Start {

	public static void main(String[] args) throws Exception{

		LdapConnection connection = new LdapNetworkConnection( "localhost", 389 );
		connection.bind( "cn=user-name ou=serviceaccounts, dc=ddc dc =net", "password" );
		EntryCursor cursor = connection.search( "DC=DDC DC=net","sAMAccount=userIDtoSearch", SearchScope.SUBTREE,
				"*" );

		while ( cursor.next() )
		{
			Entry entry = cursor.get();
			System.out.println(entry);

		}

		connection.unBind();
		connection.close();


	}
}
