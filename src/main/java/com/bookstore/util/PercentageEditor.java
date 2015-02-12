package com.bookstore.util;

import java.beans.PropertyEditorSupport;

/**
 * A formatter for Percentage properties. Converts object values to
 * well-formatted strings and strings back to values. Usable by a data binding
 * framework for binding user input to the model.
 */
public class PercentageEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Percentage percentage = (Percentage) getValue();
		if (percentage == null) {
			return "";
		} else {
			return percentage.toString();
		}
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text != null && text.length() > 0) {
			setValue(Percentage.valueOf(text));
		} else {
			setValue(null);
		}
	}

}
