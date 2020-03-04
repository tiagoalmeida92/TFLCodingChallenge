package com.tiago.tflcodingchallenge

import androidx.test.rule.ActivityTestRule
import com.tiago.tflcodingchallenge.bdd.Given
import com.tiago.tflcodingchallenge.bdd.Then
import com.tiago.tflcodingchallenge.bdd.When
import com.tiago.tflcodingchallenge.bdd.arrangements.ServerRule
import com.tiago.tflcodingchallenge.ui.MainActivity
import org.junit.Rule

open class MotherTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @get:Rule
    val serverRule = ServerRule()

    protected val given = Given(activityRule, serverRule)
    protected val `when` = When()
    protected val then = Then()
}
