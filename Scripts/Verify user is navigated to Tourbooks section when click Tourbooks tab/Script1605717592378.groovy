import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://www.google.com/')

WebUI.navigateToUrl('https://www.propertycapsule.com/')

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Verify user is navigated to Tourbooks section when click Tourbooks tab/click tourbooks'), 
    0)

WebUI.click(findTestObject('Verify user is navigated to Tourbooks section when click Tourbooks tab/click tourbooks'))

WebUI.delay(2)

String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

String currentPage1 = WebUI.getUrl()

WebUI.verifyMatch(currentPage1, 'https://tours.propertycapsule.com/', false)

int currentTab1 = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab1 - 1)

WebUI.verifyNotMatch(currentPage, currentPage1, false)

String currentPage2 = WebUI.getUrl()

WebUI.verifyMatch(currentPage2, 'https://www.propertycapsule.com/', false)

WebUI.closeBrowser()

