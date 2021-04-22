# Example

This package is a demonstration of how the gui package can be used. The focus of this package is to provide a basic GUI 
system that can simulate a mobile phone screen.

This exmaples provides a suggestion to how everything can be split up using the MVC controller.

## Form

This is a basic extension of JFrame that when the form is shown, it centralises the form in the user's display.

## Screen

This is a class that should not be obstantiated, and should only be used through it's static methods.

It exists to try and simulate the screen of a mobile phone, where only one form can be shown at once. On 
startup, you can register all of the forms that you need by using `Screen.registerForm("<form name here", new CustomForm())`.
Then when you want to show a form, you can use `Screen.show("<form name here>")` from anywhere.

When creating a form, you will need to specify a screen size. To get the same form size accross all of the forms, use the 
dimension provided by `Screen.getDefaultScreenSize()' method.


## LoginFormController

This class is an example of a controller. It is responsible for managing what happens when the user does something.

A controller should provide methods that allow binding the actual form elements to the methods that are called on events (such as a button press).

## LoginForm

This class contains the formatting for the login form, and for binding the components to the controller.

The controller should be passed to the form through a constructor, and then it should bind the components to the controller using the methods provided by the controller.