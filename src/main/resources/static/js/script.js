console.log("Hello Base")
const toggleSidebar = () => {
    console.log("toggleSidebar");

    if ($(".sidebar").is(":visible")) {

        $(".sidebar").css("display", "none");
        $(".content").css("margin-left", "0%");

    } else {
        $(".sidebar").css("display", "block");
        $(".content").css("margin-left", "20%");

    }
};
/*Load user image*/
const loadFile = function (event) {
    const output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        // $(".photoDiv").css("display","block");
        URL.revokeObjectURL(output.src) // free memory
    }
};

const search = () => {
    console.log("Searching......");
    let query = $("#search-input").val();

    if (query === ''){
        $(".search-result").hide();

    }else {
        // search
        console.log(query);
        // sending request to the server
        let url = `http://localhost:8181/search/${query}`;
        // modern js used promise no need to use ajax
        fetch(url).then((response) =>{
            return response.json();
        } ).then((data)=>{
            // data
            console.log(data);
            // show data in html
            let text = `<div class='list-group'>`;
            data.forEach((contact)=>{
                text += `<a href="/user/${contact.cId}/contact" style="background: whitesmoke" class="list-group-item list-group-item-action">${contact.name}</a>`;
            });
            text += `</div>`
            // show search result using jquery
            $(".search-result").html(text).show();

           // $(".search-result").show();
        });


    }
}

