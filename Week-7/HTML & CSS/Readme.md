# HTML
* HyperText Markup Language
* Very similar to XML but HTML is used to define the structure of your webpage
* Our browsers are essentially experts at reading this files and displaying it
* We are currently version HTML5

## HTML Elements
* They are basic graphical units that will display or structure your web page
## HTML Tags
* HTML element is the actual uniot while HTML tags is used to refer to that HTML element in your document
* Ex: div HTML element will structure your HTML doc and you use `<div></div>` HTML tag to user it

## Block vs Inline Elements
* Block elements will display the two HTML elements in different lines
* Inline elements will display the two HTML elements in the same line

## Semantic Tags
* A new edition to HTML 5
* Whole purpose of semantic tags is to express a clearly defined purpose of a certain section of your HTML file
* TLDR a proper way to "structure" your HTML file so the next person who checks this file will understand right away what's the point of that section

## Self closing tag
* It is when a HTML tag doesn't need a closing tag i.e. `</tagName>`
* This is because you cannot nest another element inside that HTML element

## HTML attributes
* They are used to provide extra information that the tag can use
* Ex: img tag uses src attribute to find a specific image to display

# CSS
* Cascading Style Sheets
    * Cascading is in the name because it uses cascading algorithm to determine what style it should apply
* A way to stop making your website looking like it came from the 90s

## CSS Selectors
* Before applying styles everywhere, we need a way to select specific or group of HTML elements first so we give them their own look
1. Id selector - When you want to select one element to apply styling
2. Class selector - When you want to select multiple elements of different HTML tags by using the class attribute
3. Element selector - When you want to target a specific HTML element and apply style to it all

## CSS Specificity
* Key thing is the term "Specificity"
* This will determine what style we should apply to a particular element because sometimes some styling will collide with another
* General rule:
    * Inline CSS will have the highest priority
    * Id selector will have high priority
    * class selector will have second priority
    * element selector will have third priority

## CSS Different ways to include CSS
* Inline CSS
    * Applies CSS to a single element
    * It uses the style attribute
* Internal CSS
    * Applies CSS by using the style tag inside a HTML doc
    * Used to apply multiple CSS to multiple elements
* 