function listRestaurant() {
    // this function will render a list of restaurants
    // grabbing the parent element 
    let parentDiv = document.getElementById("restaurants");

    // create a table element to hold restaurants
    let table = document.createElement("table");
    table.className = "table";
    // create a dummy list of restaurants that we "got" from
    // an api
    // technically in JS, string literals should be surrounded by single quotes, 
    // but JS also is okay with double quotes
    let restaurants = ["I Don't Know", "Whatever", "Jollibee", "Los Pollos Hermanos"];

    // fun stuff with collections
    // js foreach
    // goal: for each restaurant, I want a new row in the table element 
    restaurants.forEach(restaurant => {
        // create a row element to store the restaurant in
        let row = table.insertRow();
        // tables in html: table>tbody>tr>td
        // create a td element on the row
        // we're putting this info on the first column
        // so index 0
        let rowData = row.insertCell(0);
        // set the innerHTML ie <td>innerHTML</td> to be the 
        // restaurant name
        rowData.innerHTML = restaurant;

        // adding event listener to each row so you get the
        // menu items for a specific restaurant
        // another way to create anonymous function in JS
        row.onclick = function () {
            getMenuItems(restaurant);
        }
    });
    // add the table element to the parentDiv
    parentDiv.appendChild(table);
}

function getMenuItems(restaurant) {
    // create hard coded menus for restaurants
    let JollibeeMenu = ['Burger Steak', 'Chickenjoy'];
    let LPHMenu = ['Pollo'];
    let WhateverMenu = ['Some stuff', 'menu item 2'];
    let IDKMenu = ['Mystery meat', 'Mystery meal'];

    // get the parent we want to append children to
    let parentDiv = document.querySelector("#restaurants");
    // remove the list of restaurants, we're replacing
    // it with a list of menu items instead
    // this is how you delete nodes using DOM manipulation
    parentDiv.removeChild(parentDiv.firstElementChild);

    // create a table to hold menu items of our restaurant
    var table = document.createElement("table");
    table.className = "table";
    // adding header to table
    var theader = table.insertRow();
    var headerValue = theader.insertCell(0);
    headerValue.innerHTML = restaurant + ' menu';
    let menuItems;
    // switch menu to present depending on the restaurant value selected
    switch (restaurant) {
        case "Jollibee":
            menuItems = JollibeeMenu;
            break;
        case "Los Pollos Hermanos":
            menuItems = LPHMenu;
            break;
        case "I Don't Know":
            menuItems = IDKMenu;
            break;
        case "Whatever":
            menuItems = WhateverMenu;
            break;
    }

    // create a table that presents the menu items
    menuItems.forEach(menuItem => {
        let row = table.insertRow();
        let rowData = row.insertCell(0);
        // menu item name
        rowData.innerHTML = menuItem;
        row.onclick = () => {
            add2cart(menuItem);
        }
    });
    parentDiv.appendChild(table);

}

function add2cart(menuItem) {
    let cart = document.getElementById("cart");
    let cartItem = document.createElement("p");
    cartItem.innerHTML = menuItem;
    cart.appendChild(cartItem);
}