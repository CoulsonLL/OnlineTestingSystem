/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validate(){
    var npsd1=document.getElementsByClassName("npsd1")[0].value;
    var npsd2=document.getElementsByClassName("npsd2")[0].value;
    if(npsd1===npsd2){
        document.getElementsByClassName("tishi")[0].innerHTML="<font color=green>两次输入的密码相同</font>";
        document.getElementsByClassName("submit")[0].disabled=false;
    }
    else{
        document.getElementsByClassName("tishi")[0].innerHTML="<font color=red>两次输入的密码不同</font>";
        document.getElementsByClassName("submit")[0].disabled=true;
    }
}

