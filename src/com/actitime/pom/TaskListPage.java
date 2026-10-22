package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	private WebElement addNewCustomerBtn;
	
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	private WebElement addNewprojectBtn;
	
	@FindBy(id = "customerLightBox_nameField")
	private WebElement customerNameTbx;
	
	@FindBy(id = "customerLightBox_descriptionField")
	private WebElement descriptionTbx;
	
	@FindBy(xpath = "//button[contains(text(),'active customer')]")
	private WebElement activeCustImport;
	
	@FindBy(xpath = "//label[text()='Import projects descriptions']/../..//input")
	private WebElement projectDesrCheckBox;
	
	@FindBy(xpath = "//label[text()='Import tasks descriptions']/../..//input")
	private WebElement tasksDesrCheckBox;
	
	@FindBy(xpath = "//span[contains(text(),'Create Customer')]")
	private WebElement createCustbtn;
	
	@FindBy(xpath = "//div[@class='navigationLinks']/../div[@class='title ellipsis']")
	private WebElement actualCustomerName;
	
	@FindBy(xpath = "//div[@class='customerNamePlaceHolder']//div[@class='nameInput']//input")
	private WebElement editCustTbx;
	
	public WebElement getActualCustomerName() {
		return actualCustomerName;
	}

	public void setActualCustomerName(WebElement actualCustomerName) {
		this.actualCustomerName = actualCustomerName;
	}

	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public void setAddNewBtn(WebElement addNewBtn) {
		this.addNewBtn = addNewBtn;
	}

	public WebElement getAddNewCustomerBtn() {
		return addNewCustomerBtn;
	}

	public void setAddNewCustomerBtn(WebElement addNewCustomerBtn) {
		this.addNewCustomerBtn = addNewCustomerBtn;
	}

	public WebElement getAddNewprojectBtn() {
		return addNewprojectBtn;
	}

	public void setAddNewprojectBtn(WebElement addNewprojectBtn) {
		this.addNewprojectBtn = addNewprojectBtn;
	}

	public WebElement getCustomerNameTbx() {
		return customerNameTbx;
	}

	public void setCustomerNameTbx(WebElement customerNameTbx) {
		this.customerNameTbx = customerNameTbx;
	}

	public WebElement getDescriptionTbx() {
		return descriptionTbx;
	}

	public void setDescriptionTbx(WebElement descriptionTbx) {
		this.descriptionTbx = descriptionTbx;
	}

	public WebElement getActiveCustImport() {
		return activeCustImport;
	}

	public void setActiveCustImport(WebElement activeCustImport) {
		this.activeCustImport = activeCustImport;
	}

	public WebElement getProjectDesrCheckBox() {
		return projectDesrCheckBox;
	}

	public void setProjectDesrCheckBox(WebElement projectDesrCheckBox) {
		this.projectDesrCheckBox = projectDesrCheckBox;
	}

	public WebElement getTasksDesrCheckBox() {
		return tasksDesrCheckBox;
	}

	public void setTasksDesrCheckBox(WebElement tasksDesrCheckBox) {
		this.tasksDesrCheckBox = tasksDesrCheckBox;
	}

	public WebElement getCreateCustbtn() {
		return createCustbtn;
	}

	public void setCreateCustbtn(WebElement createCustbtn) {
		this.createCustbtn = createCustbtn;
	}

	public WebElement getEditCustTbx() {
		return editCustTbx;
	}

	public void setEditCustTbx(WebElement editCustTbx) {
		this.editCustTbx = editCustTbx;
	}
	
	
}
