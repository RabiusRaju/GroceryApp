package com.example.groceryapp.utility

import timber.log.Timber

/**
 * Created by MD.Rabius sani raju on 9/19/22.
 */
class CustomDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "LOG: (${element.fileName}:${element.lineNumber})#${element.methodName}"
    }
}