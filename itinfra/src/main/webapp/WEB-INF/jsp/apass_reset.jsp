<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="dist/img/logo-white.ico">
  <!-- Font & Icon -->
  <link rel="stylesheet" href="dist/font/roboto/roboto.min.css" id="font-css">
  <link rel="stylesheet" href="plugins/material-design-icons-iconfont/material-design-icons.min.css">
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="dist/css/materialdesignicons.css">
  <link rel="stylesheet" href="dist/DataTables/datatables.css">
  <!-- Plugins -->
  <!-- CSS plugins goes here -->
  <!-- Main Style -->
  <link rel="stylesheet" href="plugins/simplebar/simplebar.min.css">
  <link rel="stylesheet" href="dist/css/style.min.css" id="main-css">
  <link rel="stylesheet" href="dist/css/sidebar-royal.min.css" id="theme-css">
  <!-- options: blue,cyan,dark,gray,green,pink,purple,red,royal,ash,crimson,namn,frost -->
  <link rel="stylesheet" href="dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="dist/css/style_new.css">
  <title>golfzone::ZOIMARU</title>
</head>
<body>
	<!-- 비밀번호 변경 alert:Start -->
  <div class="modalz" id="info_a1">
    <div class="modalz_body small">
      <div class="modalz_tit">
        비밀번호변경
        <a class="pop-x-btn"></a>
      </div>
      <div class="modalz_con">
        <div class="alert_text">
          비밀번호 변경이 완료 되었습니다. <br> 확인을 누르시면 로그인 페이지로 이동 합니다.
        </div>
      </div>
      <div class="modalz_foot">
        <a href="login.do" class="newbtns bg1">확인</a>
        <a href="#" class="newbtns modalclose">취소</a>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  <!-- 비밀번호 변경 alert:End -->

  <div class="logins">
    <div class="login_body">
      <div class="login">
        <!-- <div class="login_head">
          <ul>
            <li><img src="/dist/img/infracube_logo.png"></li>
            <li class="tit">IT-Infra</li>관리시스템</li>
          </ul>
          <p>계정</p>
        </div> -->
        <div class="login_con">
          <div class="card-header bg-primary text-white flex-column">
            <h4 class="text-center mb-0">비밀번호 변경</h4>
            <div class="text-center opacity-50 font-italic">IT-Infra Management System</div>
          </div>
          <ul>
            <li><input type="text" class="login_input" placeholder="이메일"></li>
            <li><input type="text" class="login_input" placeholder="OTP 숫자 6자리"></li>
            <li><div class="small text-right text-danger"><h5>(3:00)</h5></div></li>
            
            <li><input type="password" class="login_input" placeholder="비밀번호"></li>
            <li><input type="password" class="login_input" placeholder="비밀번호확인"></li>
            <li class="line"></li>
            <li class="logbtn">
              <!-- <button class="newbtn bg1 info_a1 login_btn bg1" onclick="location.href='login.html'">확인</button> -->
              <button class="newbtn bg1 info_a1 login_btn bg1">확인</button>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <!-- Main Scripts -->
  <script src="dist/js/jquery.min.js"></script>
  <script src="dist/DataTables/datatables.js"></script>
  <script src="dist/js/bootstrap.bundle.min.js"></script>
  <script src="plugins/simplebar/simplebar.min.js"></script>
  <script src="plugins/feather-icons/feather.min.js"></script>
  <script src="dist/js/bootstrap-datepicker.min.js"></script>
  <script src="dist/js/script.min.js"></script>
  <!-- Plugins -->
  <!-- JS plugins goes here -->
  <script>
    $(document).ready(function () {
      $('.userser').click(function () {
        $('#userser').addClass('act');
      });
      $('.sms').click(function () {
        $('#sms').addClass('act');
      });

      $('.info_a1').click(function () {
        $('#info_a1').addClass('act');
      });
      
      $('.pop-x-btn, .modalclose').click(function() {
          var tmp = $(this).parents().parents().parents()
          if (tmp.attr('class') == 'modalz act') {
              tmp.removeClass('act');
          } else {
              //tmp.removeClass('act');
          }
      });
    });

  </script>
</body>
</html>