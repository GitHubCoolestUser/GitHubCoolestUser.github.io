var item = document.querySelectorAll(".boxMain");
var title = document.querySelectorAll(".boxTitle");

console.log(item); 
console.log(title);



for(let i = 0; i < item.length; i++){
    item[i].classList.add(hidden);
    title[i].addEventListener("click", function(event){
        console.log("click"+event);
    });
}

