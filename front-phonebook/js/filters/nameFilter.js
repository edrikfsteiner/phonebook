app.filter("name", function() {
    return function(input) {
        if (!input) {
            return "";
        }
        let nameList = input.split(" ");
        let nameListFormat = nameList.map(function(name) {
            return name.charAt(0).toUpperCase() + name.substring(1).toLowerCase();
        });
        
        return nameListFormat.join(" ");
    };
});