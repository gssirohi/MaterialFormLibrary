package com.gssirohi.materialformapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gssirohi.materialforms.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = mutableListOf<FormItem>()
        items.add(FormItem(Field.Text("","Name",true,true),R.drawable.ic_action_user))
        items.add(FormItem(Field.SingleChoice(false,"I am above 18",true),R.drawable.ic_face))
        items.add(FormItem(Field.Text("abc@gmail.com","Email",true,true),R.drawable.ic_email))
        var myForm = MaterialFormBuilder(this).title("To Do Form")
            .addItems(items)
            .onSubmitListner(object:MaterialForm.FormListner{
                override fun onFormSubmit(items: List<FormItem>) =
                    Toast.makeText(this@MainActivity,"Curr Value: ${items.get(0).field.currValue()}",Toast.LENGTH_SHORT).show()
            })
            .build()
        todo_form_container.addView(myForm)

    }
}
