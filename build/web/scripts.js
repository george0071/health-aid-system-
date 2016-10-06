/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function symptoms() {
    var e;
    try {
        e = document.getElementById("mySymp").value;
        if (e == null || e == "") {
            alert("Symptoms must be filled");
            return false;
        }
    } catch (a) {
        alert("nice");
    }
}

function next()
{
    window.location = "http://localhost:8080/health_aid_system/WEB-INF/index5.html";
}





        