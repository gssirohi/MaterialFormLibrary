package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Switch

class SingleChoiceView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.input_single_choice,null)
        (view as Switch).text = item.field.label
        (view as Switch).setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                item.field.setCurrValue(isChecked)
            }
        })
        return view
    }

    init{
        Log.d("SingleChoiceView","init")
        initView()
    }
}