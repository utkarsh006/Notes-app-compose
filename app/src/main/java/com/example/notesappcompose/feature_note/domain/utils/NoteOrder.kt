package com.example.notesappcompose.feature_note.domain.utils

sealed class NoteOrder(val orderType: OrderType){
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)
}

//We have 3 different ways of ordering a list of notes :)
