package demo.pages.room

import demo.modules.Nav
import demo.pages.booking.BookingShowPage
import geb.Page
import geb.module.TextInput

class CreateRoomPage extends Page {

    static at = {
        title == 'Create Room'
    }

    static url = "/room/create"

    static content = {
        inputField {
            $('input', name: it).module(TextInput)
        }
        saveButton(to: BookingShowPage) {
            $('input', type: 'submit')
        }
        nav { $('div.nav').module(Nav) }
    }

    void setName(String name) {
        populate('name', name)
    }

    void save() {
        saveButton.click()
    }

    protected void populate(String inputFieldName, String value) {
        inputField(inputFieldName).text = value
    }
}