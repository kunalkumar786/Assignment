package com.example.assignment.ui.login

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator:TextWatcher{
private var mIsValid=false

    fun isValid(): Boolean {
        return mIsValid
    }

companion object{

    val EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )


    fun isValidEmail(email: CharSequence?): Boolean {
        return email != null && EMAIL_PATTERN.matcher(email).matches()
    }

}



    override fun afterTextChanged(editableText: Editable?) {
        mIsValid = isValidEmail(editableText);

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


    }

}