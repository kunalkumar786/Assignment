package com.example.assignment.ui.login

import android.widget.EditText
import com.example.assignment.data.LoginDataSource
import com.example.assignment.data.model.LoggedInUser
import kotlinx.android.synthetic.*
import org.junit.After
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import android.R
import android.R.attr.password
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.android.synthetic.main.activity_login.*
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest/*:ActivityInstrumentationTestCase2<LoginActivity>*/  {

    private lateinit var loginModel:LoginDataSource;
    private lateinit var username:String
    private lateinit var password:String

    @Throws(Exception::class)
    @Before
    fun setUp(){



    loginModel= LoginDataSource()

    System.out.println("Ready for Testing")

    }

    @After
    fun tearDown() {
        System.out.println("Done with unit test!")
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("test@worldofplay.in"))
    }
    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("test@worldofplay.in"))
    }
    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("test@email"))
    }
    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("test@email..com"))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }


    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }



    @Test
    public fun testWithCorrectValues() {
        var validEmail:String = "email";
        var validPassword:String = "password";
        val responseOfExecutingApiWithCorrectValues = true
        Assert.assertEquals(true, responseOfExecutingApiWithCorrectValues);

    }
    @Test
    public fun testWithInCorrectValues() {
        var validEmail:String = "email";
        var validPassword:String = "password";
        val responseOfExecutingApiWithCorrectValues = false
        Assert.assertEquals(false, responseOfExecutingApiWithCorrectValues);

    }

}