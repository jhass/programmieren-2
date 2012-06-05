package de.fhh.pr2.jhass.u.b3;

import java.awt.print.*;
import java.net.*;
import java.security.cert.*;
import java.sql.*;
import java.io.*;
import javax.naming.*;
import javax.sql.rowset.spi.*;

public class Strange {
	public static void main(String[] args) {
		try {
			f();
		} catch (RuntimeException | // ArithmeticException, ArrayStoreException
				 Error | // IOError, AssertionError
				 CertificateException | // self, CertificateNotYetValidException
				 NamingException | // self, InvalidNameException, OperationNotSupportedException
				 IOException | // self, MalformedURLException, FileNotFoundException
				 CloneNotSupportedException | // self 	
				 PrinterException | // self
				 SQLException e // self, SyncProviderException
				) {
			e.printStackTrace();
		}
	}
	public static void f() throws ArithmeticException, NamingException,
			InvalidNameException, IOException, MalformedURLException,
			SyncProviderException, CertificateNotYetValidException, IOError,
			OperationNotSupportedException, ArrayStoreException,
			CloneNotSupportedException, FileNotFoundException,
			PrinterException, SQLException, CertificateException,
			AssertionError {
	}
}