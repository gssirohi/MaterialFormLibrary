package com.gssirohi.materialforms

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.field_text_input.view.*

class TextInputView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    init{
        Log.d("TextInputView","init")
        initView()
    }

    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.field_text_input,null)
        view.field_input_text.hint = item.field.label
        view.field_input_text.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                item.field.setCurrValue(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        return view
    }
}