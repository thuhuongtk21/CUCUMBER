package interfaces;

public class AbstractPageUI {
	
	public static final String DYNAMIC_PAGE_LINK = "//a[text()='%s']";
	public static final String LOGIN_PAGE_FORM = "//form[@name='frmLogin']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_INPUT_TEXTBOX = "//input[@name ='%s']";
	public static final String DYNAMIC_ATTRIBUTE = "//td[text()='%s']/following-sibling::td";

}
