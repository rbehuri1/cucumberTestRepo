/**
 * rsr 
 *
 *Aug 6, 2016
 */
package interfaces;

import enums.DriverType;

public interface IconfigReader {
	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public DriverType getBrowser();
}
