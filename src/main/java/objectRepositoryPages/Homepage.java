package objectRepositoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.BaseClass;

public class Homepage extends BaseClass {
	
	//class add as constructor and extend baseclass
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
	private WebElement Email;
	
	public WebElement getEmailbtn() {
		return Email;
	}
	
	@FindBy(xpath ="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	private WebElement Password;

	public WebElement getPassBtn() {
		return Password;
	}
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-fullWidth css-1rijiyb']")
	private WebElement Login;

	public WebElement getLogin() {
		return Login;
	}
	
	@FindBy(xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge css-ic1i4k']")
	private WebElement Popup;

	public WebElement getPopup() {
		return Popup;
	}
	
	@FindBy(xpath ="//span[text()='3P Chargebacks']")
	private WebElement Charback;

	public WebElement getCharback() {
		return Charback;
	}
	
	@FindBy(xpath ="//span[text()='History by Store']")
	private WebElement History;

	public WebElement getHistory() {
		return History;
	}
	
	@FindBy(xpath ="//span[text()='Transactions']")
	private WebElement Trans;

	public WebElement getTrans() {
		return Trans;
	}
	
	@FindBy(xpath ="//div[@class='MuiBox-root css-1pswuk']//child::button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge css-y1p833-MuiButtonBase-root-MuiButton-root'][1]")
	private WebElement Locations;

	public WebElement getLocations() {
		return Locations;
	}
	
	@FindBy(xpath ="//p[@class='MuiTypography-root MuiTypography-body1 css-18uqk31-MuiTypography-root']")
	private WebElement Unselect;

	public WebElement getUnselect() {
		return Unselect;
	}

	@FindBy(xpath ="//p[text()='Artisan Alchemy']")
	private WebElement ArtAlc;

	public WebElement getArtAlc() {
		return ArtAlc;
	}
	
	@FindBy(xpath ="//p[text()='Blissful Buffet']")
	private WebElement BliBuf;

	public WebElement getBliBuf() {
		return BliBuf;
	}
	
	@FindBy(xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall css-1un93pa-MuiButtonBase-root-MuiButton-root']")
	private WebElement Apply1;

	public WebElement getApply1() {
		return Apply1;
	}
	
	@FindBy(xpath ="//div[@class='MuiBox-root css-1pswuk']//child::button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge css-y1p833-MuiButtonBase-root-MuiButton-root'][3]")
	private WebElement MarketPlace;

	public WebElement getMarketPlace() {
		return MarketPlace;
	}
	
	@FindBy(xpath ="//p[text()='Unselect All (3)']")
	private WebElement Unselect1;

	public WebElement getUnselect1() {
		return Unselect1;
	}
	
	@FindBy(xpath ="//p[text()='Grubhub']")
	private WebElement GrubHub;

	public WebElement getGrubHub() {
		return GrubHub;
	}
	
	@FindBy(xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall css-1un93pa-MuiButtonBase-root-MuiButton-root']")
	private WebElement Apply2;

	public WebElement getApply2() {
		return Apply2;
	}
	
	@FindBy(xpath ="//table[@class='MuiTable-root css-15i8i05-MuiTable-root']")
	private WebElement Table;

	public WebElement getTable() {
		return Table;
	}
	
}
