        //  회원의 정보 : 아이디, 비밀번호, 이름
        //  Member -> 생성자 함수를 정의

        function Member(id, pw, name) {
            this.userId = id;
            this.pw = pw;
            this.userName = name;
        }
        // 객체가 가지는 메소드는 공통으로 사용 -> prototype
        Member.prototype.makeHtml = function () {
            return '[id: ' + this.userId + ', pw: ' + this.pw + ', name: ' + this.userName + ']'
        };
        //////////////////////////////////////

        // 회원의 정보를 저장하는 배열
        var members = []; // new Array()



        $(document).ready(function () {

             // localStorage 저장된 데이터가 있는지 확인
            // localStorage.getItem('members') 없으면 null 반환
            if(localStorage.getItem('members') == null) {
                // 배열 members를 저장
                localStorage.setItem('members', JSON.stringify(members));

            } else {
            members = JSON.parse(localStorage.getItem('members')); // JSON 문자열 -> 객체로 변환
            console.log(members);
            // 테이블 세팅
                setList();
            }


            var userid = $('#userID');
            var pw = $('#pw');
            var repw = $('#repw');
            var userName = $('#userName');

            // regForm 캐스팅
            var regForm = $('#regForm');
            var emailForm = /\w+@\w+\.\w+/;

            // 잘못입력시 문구가 나오도록
           regForm.submit(function () {

                if (userid.val().trim().length < 1) {
                    //  alert('아이디입력');
                    
                    $('#userID+div.msg').text('필수항목 입니다');
                    $('#userID+div.msg').css('display','block');

                    return false;
                }

                if(!emailForm.test(userid.val())){
                    $('#userID+div.msg').text('이메일 형식으로 입력하세요');
                    $('#userID+div.msg').css('display','block');

                    return false;
                }

                if (pw.val().trim().length < 1) {
                    
                    $('#pw+div.msg').html('필수항목 입니다');
                    $('#pw+div.msg').css('display','block');

                    return false;
                }

                if (repw.val().trim().length < 1) {
                    
                    $('#repw+div.msg').html('필수항목 입니다.');
                    $('#repw+div.msg').css('display','block');

                    return false;
                    // e.stopPropagation();
                }

                if(pw.val().trim() != repw.val().trim()){

                    $('#repw+div.msg').html('비밀번호가 일치하지 않습니다.');
                    $('#repw+div.msg').css('display','block');

                    return false;
                }

                if (userName.val().trim().length < 1) {
                    
                    $('#userName+div.msg').html('필수항목입니다.');
                    $('#userName+div.msg').css('display','block');

                    return false;
                }
                console.log(userid.value);
                console.log(pw.value);
                console.log(repw.value);
                console.log(userName.value);
        

              // 배열에 사용자 정보를 추가
            members.push(new Member(userid.val(), pw.val(), userName.val()));

                // 저장
            localStorage.setItem('members', JSON.stringify(members));

            alert('등록되었습니다.');
            console.log('회원 리스트' , members)

                // form 초기화
            this.reset();

                // 테이블 세팅
            setList();
                return false;

            });

            // 이벤트를 지워주는 focus 설정
            userid.focus(function(){
                $('#userID+div.msg').css('display','none');
                $('#userID+div.msg').html('');
            });

            pw.focus(function(){
                $('#pw+div.msg').css('display','none');
                $('#pw+div.msg').html('');
            });

            repw.focus(function(){
                $('#repw+div.msg').css('display','none');
                $('#repw+div.msg').html('');
            });

            userName.focus(function(){
                $('#userName+div.msg').css('display','none');
                $('#userName+div.msg').html('');
            });



        });

    function setList(){
    
        // table에 tbody 캐스팅
        var list = $('#list');


        // var tbody = list.innerHTML;

        var tbody = '<tr>';
        tbody += '<th>순번(index)</th>';
        tbody += '<th>아이디</th>';
        tbody += '<th>비밀번호</th>';
        tbody += '<th>이름</th>';
        tbody += '<th>관리</th>';
        tbody += '</tr>';



        if(members.length<1){

            tbody +='<tr>';
            tbody +='<td colspan=5> 데이터가 존재하지 않습니다. </td>';
            tbody +='</tr>';

        }else {

            for(var i=0; i<members.length; i++){
                tbody += '<tr>';
                tbody += '<td>'+i+'</td>';
                tbody += '<td>'+members[i].userId+'</td>';
                tbody += '<td>'+members[i].pw+'</td>';
                tbody += '<td>'+members[i].userName+'</td>';
                tbody += '<td> <a href="javascript:editMember('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></td>';
                tbody += '</tr>';
            
                }

        }
        $(list).html(tbody)
    }
    // 배열의 요소 삭제 함수
    function deleteMember(index) {
        // alert(index+'인덱스의 요소를 삭제합니다');

        // var chk = confirm('삭제하시겠습니까?');

        // 배열의 index 요소를 삭제합니다
        // splice(index, count) : index에서 시작해서 
        // count 만큼의 요소를 삭제하고 남은 요소의 배열을 반환
        // splice(index, 1)
        if(confirm('삭제하시겠습니까?')){
            members.splice(index, 1);
            alert('삭제되었습니다.');

            // 저장
            localStorage.setItem('members', JSON.stringify(members));
            // 테이블 리스트 갱신
            setList();
        }
    }
    // 배열의 요소 수정하는 함수
    function editMember(index) {

        // 수정폼 영역이 노출되어야 한다

        $('#editFormArea').css('display','block');


        // alert(index + '인덱스의 요소를 수정합니다');

        // 전달받은 index 값으로 members 배열의 객체 하나를 얻을 수 있다!
        console.log(index,members[index]);

        // editForm의 태그들의 value 값을 세팅
        var editUserId = $('#editId');
        var editPw = $('#editPw');
        var editRePw = $('#editRePw');
        var editName = $('#editName');
        var editIndex = $('#index');


        // 이전 데이터를 폼에 세팅
        editUserId.val(members[index].userId);
        editPw.val(members[index].pw);
        editRePw.val(members[index].pw);
        editName.val(members[index].userName);
        editIndex.val(index);

        $('#editForm').submit(function(){

        // var member = new Member(editUserId.val(), editPw.val(), editName.val());
        // console.log(editIndex.value ,member);

        //  비밀번호와 비밀번호 확인이 같은지 체크
        if(editPw.val() != editRePw.val()){
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다');
            return false;
        }

        if(!confirm('수정하시겠습니까?')){

            return false;

        }

        members[editIndex.val()].pw = editPw.val();
        members[editIndex.val()].userName = editName.val();

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');


        setList();

        editMemberClose();        

        return false;
        });

    }

function editMemberClose(){
    $('#editFormArea').css('display','none');
} 