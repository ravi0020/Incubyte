package com.incubyte.gmail.step_definitions;

import com.incubyte.gmail.configure.Config;
import com.incubyte.gmail.pages.Homepage;
import com.incubyte.gmail.pages.InboxMailPage;
import com.incubyte.gmail.pages.LoginPage;
import com.incubyte.gmail.utility.WebUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class GmailTestStepDefinitions {

	
	InboxMailPage inboxMailPage = new InboxMailPage();

	@Given("^User open given browser window$")
	public void user_open_something_browser_window() throws Throwable {

		WebUtil.openBrowser();
	}

	@And("^User naviagte to given yahoo url$")
	public void user_naviagte_to_given_something_url() throws Throwable {

		WebUtil.openUrl(Config.getGmailUrl());

	}

	@And("^User enter username and password and do login from login page$")
	public void user_enter_username_and_password_and_do_login_from_login_page() throws Throwable {
		new LoginPage().doLogin();
	}

	@And("^User click on the mail box link from the homepage$")
	public void user_click_on_the_mail_box_link_from_the_homepage() throws Throwable {

		new Homepage().clickOnMailBoxLink();
	}

	@And("^User click on the compose button on inbox mail page$")
	public void user_click_on_the_compose_button_on_inbox_mail_page() throws Throwable {

		inboxMailPage.clickOnComposeButton();
	}

	@And("^User enter To receipent email id on compose mail page$")
	public void user_enter_to_receipent_email_id_on_compose_mail_page() throws Throwable {

		inboxMailPage.enterToReciepentOfComposeMail();
	}

	@And("^User enter subject on compose mail page$")
	public void user_enter_subject_on_compose_mail_page() throws Throwable {

		inboxMailPage.enterSubjectOfComposeMail();
	}

	@And("^User enter some message in message body on compose mail page$")
	public void user_enter_some_message_in_message_body_on_compose_mail_page() throws Throwable {

		inboxMailPage.enterMessageOfComposeMail();
	}

	@And("^User click on attachment button on compose mail page$")
	public void user_click_on_attachment_button_on_compose_mail_page() throws Throwable {

		inboxMailPage.clickOnAttachButton();
	}

	@And("^User click on the attach file from computer button on compose mail page$")
	public void user_click_on_the_attach_file_from_computer_button_on_compose_mail_page() throws Throwable {

		inboxMailPage.clickOnAttachFileFromComputerButton();
	}

	@And("^User upload any type of file \"([^\"]*)\" on compose mail page$")
	public void user_upload_any_type_of_file_something_on_compose_mail_page(String path) throws Throwable {

		
		inboxMailPage.uploadFile(path);
	}

	@And("^User click on send button on compose mail page$")
	public void user_click_on_send_button_on_compose_mail_page() throws Throwable {

		inboxMailPage.clickOnSendButton();
		
	}

}
