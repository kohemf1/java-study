<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
	<title>Home</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .main_body{
        background-color: #f7f7f7;
    }

    ul {
        list-style: none;
    }
    header {
        position: relative;
        z-index: 20;
        min-width: 980px;
        width: 100%;
        height: 140px;
        background-color: rgb(66, 133, 244);
        text-align: center;
    }
    .MultiBar {
        display: inline-block;
        height: 30px;
        width: 100%;
        max-width: 1280px;
        padding: 12px 0px 5px;
    } 

    .area_gnb {
        font-size: 12px;
        width: 500px;
        height: 30px;
        float: right;
        color: white;
    }

    .area_gnb>li {
        float: right;
        width: 75px;
    }

    .container {
        display: inline-block;
        height: 93px;
        width: 100%;
        max-width: 1280px;
        position: relative;
    }

    .logo {
        position: absolute;
        left: 50%;
        width: 180px;
        margin-left: -90px;
    }


    .main_naviwrap {
        display: block;
        margin: 0 auto;
        width: 100%;
        max-width: 1280px;
        height: 80px;
        margin-top: -98px;
        padding-bottom: 10px;
    }
    .main_nav {
        padding-top: 45px;
    }
    .main_nav>.left_ul {
        float: left;
        overflow: hidden;
    }
    .main_nav>.right_ul {
        float: right;
        overflow: hidden;
    }

    .main_nav>ul>li {
        color: white;
        width: 85px ;
        float: left;
    }

    .searchbar{
        
        height: 50px;
        width: 100%;
        max-width: 980px;
        padding: 12px  5px;
        color: white;
        background-color: rgb(251, 188, 006);
        margin: 30px auto;
        border: 2px solid #000;
 
    }
    .searchbar>h1 {
        float:left;
        padding: auto 20px;
        margin: 0px 10px;
    }
    .search{

        float : right;
        margin-top: 8px;
        margin-right: 20px;
        padding: auto 0px;
        /* border: 1px solid black; */
    }

    .search>input[type=text]{

        height: 30px;
        width: 250px;
    }

    .search>input[type=submit]{

        height: 34px;
        width: 50px;
        float: right;
    }

    .search>input[type=submit]:hover{
        cursor: pointer;
    }
   
    .background{
        margin: 20px auto;
        background-color:#f7f7f7;
        width: 950px;
        min-height: 1500px;
        max-width: 980px;
        overflow: hidden;
        height: auto;
        border: 1px solid rgb(251, 188, 006);
    }

    .title{
        margin-left: 30px;
        padding-top: 30px;
        
    }

    .background>hr{
        margin-top: 5px;
        width: 150px;
        margin-left: 20px;
        border: 1px solid rgb(251, 188, 006);
       
    }

    .background>.reg_wrap{
        margin: 20px auto;
        width: 880px;
        padding-top: 30px;
        height: 1370px;
        
    }
    
    .reg_img{
        width: 230px;
        float: right;
    }
    .reg_img>h3{
        width: 150px;
        float: right;
        margin-bottom: 10px;
       
    }

    .reg_default{
        float: right;
        background-color: #f7f7f7;
        width: 200px;
        height: 200px;
        box-shadow: 1px 1px 3px 1px #dadce0;
        border: 2px solid white;
    }

    .reg_default>img{
        width: 100%;
        height: 100%;
    }


    .reg_img>input{
        margin-top: 10px;
        width: 200px;
        float: right;
        box-shadow: 1px 1px 3px 1px #dadce0;
        visibility: hidden;
    }
    .reg_img>input:hover{
        cursor: pointer;
    }

    .img_btn{
        text-align: center;
        width: 200px;
        float: right;
        box-shadow: 1px 1px 3px 1px #dadce0;
        border: 1px solid #000;
    }
 
    .img_btn:hover{
        cursor: pointer;
        background-color: rgb(251, 188, 006);
    }

    .reglist{
        text-align: center;
        height: 330px;
        width: 500px;
    }
    .reg_item{
        float: left;
        width: 190px;
        height: 60px;
        text-align: right;
        padding-right: 10px;
        padding-top: 16px;
        font-size: 20px;
        font-weight: bold;
    }
    .reg_text{
        float: left;
        width: 300px;
        height: 80px;
        
    }
    .reg_text>input{
        font-size: 20px;
        width: 280px;
        height: 50px;
        border: 3px solid white;
        box-shadow: 1px 1px 3px 1px #dadce0;
       background-color: #f7f7f7; 
    }
    .reg_item2{
        float: left;
        width: 190px;
        height: 60px;
        text-align: right;
        padding-right: 10px;
        padding-top: 16px;
        font-size: 20px;
        font-weight: bold;
    }
    .reg_text2{
        float: left;
        width: 300px;
        height: 80px;
    } 
    .reg_text2>input{
        font-size: 20px;
        width: 280px;
        height: 50px;
        border: 3px solid white;
        box-shadow: 1px 1px 3px 1px #dadce0;
        background-color: #f7f7f7;
    }   

    .reg_intro{
        text-align: center;
        height: 600px;
        width: 800px; 
    }

    .reg_intro>ul{
        clear: both;
        margin-bottom: 20px;
    }
   
    .reg_intro>ul>.intro_li{
        float: left;
        width: 190px !important ;
        height: 62px;
        text-align: right;
        padding-right: 10px;
        font-size: 20px;
        font-weight: bold;
        margin-right: 10px;
    }
    
    .intro_text{
        height: 130px;
        margin: 20px auto;
    }

    .reg_intro>ul>li>textarea{
        display: block;
        border: 3px solid white;
        background-color: #f7f7f7; 
        box-shadow: 1px 1px 3px 1px #dadce0;
        resize: none;
       
    }   
    
    .reg_btn{
        width: 105px;
        height: 55px;
        margin: 10px auto;

    }
    .reg_btn>input{
        
        background-color: #f7f7f7 ;
        width:100px !important ; 
        height:40px !important ;
        text-decoration: none;
        border-radius: 10px;
        font-size: 24px;
        color: #000;   
        box-shadow: 1px 1px 3px 1px #dadce0;
    }

    .reg_btn>input:hover{ 
        background-color: rgb(251, 188, 006); 
        cursor: pointer;
    }

    a:hover{
        cursor: pointer;
    }

   
    a{
        text-decoration: none;
        color: black;
    }

</style>
<script>
    function btnclick(){
        alert('등록되었습니다');
    }


    function setImg(event) { 
        
        var reader = new FileReader(); 
        
        reader.onload = function(event) { 
            /* document.querySelector("div#image_container").removeChild(); */
           var oldImg = document.querySelector("#image_container img");
            if(oldImg != null) {
                document.querySelector("#image_container").removeChild(oldImg);
            }
            
            var newImg = document.createElement("img");
            newImg.setAttribute("src", event.target.result); 
            document.querySelector("#image_container").appendChild(newImg);
        }; 
        
       reader.readAsDataURL(event.target.files[0]); 
    }


 
</script>
<body>
<header>
        <div class="MultiBar">
            <ul class="area_gnb">
                <li>시작페이지로</li>
                <li>다크모드</li>
                <li>마이페이지</li>
                <li>로그인</li>
            </ul>
        </div>

        <div class="container">
            <img  class="logo" src="<c:url value='/image/cob_white.png'/>">
            
        </div>
        <div class="main_naviwrap">
            <div class="main_nav">
                <ul class="left_ul">
                    <li>회사소개</li>
                    <li>회사소개</li>
                    <li>회사소개</li>    
                </ul>
            </div>
        </div>

        <div class="main_naviwrap">
            <div class="main_nav">
                <ul class="right_ul">
                    <li>모임</li>
                    <li>게시판</li>
                    <li>카페</li>
                    <li>게임</li>    
                </ul>
            </div>
        </div>
    </header>

    <div class="searchbar">
        <h1><a href="cob_game_main.html">게임 DB</a></h1>


        <div class="search">
            <input type="text" id="search_text">
            <input type="submit" value="검색" id="btn1">
        </div>
    </div>

    <div class="background">

        <div class="title">
            <h2>게임등록 </h2> 
        </div>
        <hr>

        <div class="reg_wrap">

            <span class="reg_img">
                <h3>게임 이미지</h3>
                <div class="reg_default" alt="사진" id="image_container" ></div>
                
               
                <input type="file" id="image" accept="image/*" onchange="setImg(event);"/> 
                <label class="img_btn" for="image"> 이미지 등록 </label>

            </span>

            <div class="reglist">
                <ul>
                    <li class="reg_item">게임명 </li>
                    <li class="reg_text"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item">장르 </li>
                    <li class="reg_text"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item">게임인원 </li>
                    <li class="reg_text"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item">플레이타임 </li>
                    <li class="reg_text"><input type="text"></li>
                </ul>
            </div>
            <div class="reglist">
                <ul>
                    <li class="reg_item2">사용연령 </li>
                    <li class="reg_text2"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item2">게임난이도 </li>
                    <li class="reg_text2"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item2">출판사 </li>
                    <li class="reg_text2"><input type="text"></li>
                </ul>
                <ul>
                    <li class="reg_item2">출시일 </li>
                    <li class="reg_text2"><input type="text"></li>
                </ul>
            </div>

           <div class="reg_intro">
               <ul>
                    <li class="intro_li">INTRO</li>
                    <li class="intro_text"><textarea cols="60" rows="8"></textarea></li>
                   
               </ul>

               <ul>
                    <li class="intro_li">RULE</li>
                    <li class="intro_text"><textarea cols="60" rows="8"></textarea></li>
               
                </ul>

                <ul>
                    <li class="intro_li">PLAY</li>
                    <li class="intro_text"><textarea cols="60" rows="8"></textarea></li>
           
                </ul>

                <ul>
                    <li class="intro_li">ETC</li>
                    <li class="intro_text"><textarea cols="60" rows="8"></textarea></li>
            
                </ul>
            
               
           </div>
            <div class="reg_btn">
                <input type="button" value="등록" onclick="btnclick()">
            </div>
        </div>
    </div>

</body>
</html>
