package interfaces;

public class AbstractPageUI {
	
	public static final String DYNAMIC_PAGE_LINK = "//a[text()='%s']";
	public static final String LOGIN_PAGE_FORM = "//form[@name='frmLogin']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@name='%s' and @value='%s']";
	public static final String DYNAMIC_INPUT_TEXTBOX = "//input[@name ='%s']";
	public static final String DYNAMIC_INPUT_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_ATTRIBUTE = "//td[text()='%s']/following-sibling::td";
	public static final String DYNAMIC_MESSAGE = "//p[@class='heading3' and text()=\"%s\"]";
	public static final String DYNAMIC_TEXT_IN_TABLE = "//td[text()='%s']/following-sibling::td";
	public static final String DYNAMIC_DROPDOWN_LIST = "//select[@name='%s']";
	

}
