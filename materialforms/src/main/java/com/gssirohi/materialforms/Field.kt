package com.gssirohi.materialforms

sealed class Field(val type:FieldType, val label:String, var isMandatory:Boolean, var isEditable:Boolean) {
    abstract fun  currValue():Any
    abstract fun setCurrValue(obj:Any)
    class Text(var value:String,label:String,isMandatory: Boolean,isEditable:Boolean):Field(FieldType.TEXT,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as String
        }

        override fun currValue(): String {
            return value
        }
    }

    class SingleChoice(var value:Boolean,label:String,isEditable:Boolean):Field(FieldType.SINGLE_CHOICE,label,false,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as Boolean
        }

        override fun currValue(): Boolean {
            return value
        }
    }
}