<template>
  <v-card>
    <div class="main">
        
        <div class="title">
            <h3>공지사항/게시판</h3>
        </div>
        <div class="board-search">
            <div class="container">
                    <form action="" method="post" class="search-window">
                        <select name="choice" class="form-select">
                            <option value="choice_title_content">제목 + 내용</option>
                            <option value="choice_title">제목</option>
                            <option value="choice_content">내용</option>
                            <option value="choice_name">작성자</option>
                        </select>
                        <input type="search" placeholder="검색어를 입력하세요." class="form-input">
                        <button type="submit" class="form-btn">검색</button>
                        
                    </form>
            </div>
        </div>
        <div class="board-list">
            <div class="container">
                <ul class="ulTable" id="font" >
                    <li class="table_no">NO</li>
                    <li class="table_title">제목</li>
                    <li class="table_writer">작성자</li>
                    <li class="table_date">작성일</li>
                    <li class="table_view">조회수</li>
                </ul>
            </div>
            
            <div class="container">
                <ul class="ulTable">
                    <li class="table_no">7</li>
                    <li class="table_li_title">
                        <v-dialog v-model="detailNotice" max-width="80%">
                        <template v-slot:activator="{ props }">
                          <a v-bind="props">
                            공지사항
                          </a>
                        </template>
                        <v-card>
                          <v-card-text>
                            <v-container>
                              <div class="container">

                                <div class="pagetitle">
                                    <h1>게시글</h1>
                                </div>

                                <div>
                                    <table>
                                        <tr>
                                            <th >작성자</th>
                                            <td class="first-line-th"></td>
                                            <th>조회수</th>
                                            <td class="first-line-th">100</td>
                                        </tr>

                                        <tr>
                                            <th>제목</th>
                                            <td colspan="3">게시글 제목</td>
                                        </tr>

                                        <tr>
                                            <th>날짜</th>
                                            <td colspan="3">작성 날짜</td>
                                        </tr>

                                        <tr>
                                            <th>내용</th>
                                            <td colspan="3">게시글 내용이 여기에 들어갑니다.</td>
                                        </tr>
                                    </table>
                                </div>
                              </div>
                            </v-container>
                          </v-card-text>

                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-dialog v-model="updateNotice" max-width="80%">
                              <template v-slot:activator="{ props }">
                                <v-btn color="blue-darken-1"  v-bind="props">
                                  수정
                                </v-btn>
                              </template>
                              <v-card>
                                <v-card-text>
                                  <v-container>
                                    <div >
                                      <div class="big-title">
                                          <h2>게시글 수정</h2>
                                      </div>
                                      <div class="check">
                                          <strong><span class="wf-red">* </span>표시는 필수입력 항목입니다.</strong>
                                      </div>
                                      <div class="container2">
                                          <form method="post" id="formw">
                                              <fieldset class="title-form">
                                                  <legend class="legend-txt"><label for="title"><strong>제목 <span class="wf-red">*</span></strong></label></legend> 
                                                  <input type="text" class="textbox" id="title">
                                              </fieldset>
                                              <fieldset class="writter-form">
                                                  <legend class="legend-txt"><label for="writter"><strong>작성자 <span class="wf-red">*</span></strong></label></legend>
                                                  <input type="text" class="textbox" id="writter" value="운영자" readonly="readonly">
                                              </fieldset>
                                              <fieldset class="content-form">
                                                  <legend class="legend-txt"><label for="contents"><strong>내용 <span class="wf-red">*</span></strong></label></legend>
                                                  <textarea name="" id="contents" cols="100" rows="20"></textarea>
                                              </fieldset>
                                          </form>
                                          
                                      </div>
                                    </div>
                                  </v-container>
                                </v-card-text>

                                <v-card-actions>
                                  <v-spacer></v-spacer>
                                  <v-btn color="red-darken-1" variant="outlined" @click="close(1)">
                                    취소하기
                                  </v-btn>
                                  <v-btn color="blue-darken-1" variant="outlined" @click="save(1)">
                                    수정하기
                                  </v-btn>
                                </v-card-actions>
                              </v-card>
                            </v-dialog>
                            <v-btn color="red-darken-1" variant="outlined" @click="save2">
                              삭제
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </li>
                    <li class="table_writer">담당자</li>
                    <li class="table_date">xxxx-xx-xx</li>
                    <li class="table_view">20</li>
                </ul>
            </div>
            
          
            <div class="page">
                <div class="container">
                    <div class="page-num">◀</div>
                    <div class="page-num"><b>1</b></div>
                    <div class="page-num">2</div>
                    <div class="page-num">3</div>
                    <div class="page-num">4</div>
                    <div class="page-num">5</div>
                    <div class="page-num">▶</div>
                    <div class="write-btn">
                      <v-dialog v-model="dialog" max-width="80%">
                        <template v-slot:activator="{ props }">
                          <v-btn class="btn" v-bind="props">
                            글쓰기
                          </v-btn>
                        </template>
                        <v-card>
                          <v-card-text>
                            <v-container>
                              <div >
                                <div class="big-title">
                                    <h2>게시글 작성</h2>
                                </div>
                                <div class="check">
                                    <strong><span class="wf-red">* </span>표시는 필수입력 항목입니다.</strong>
                                </div>

                                

                                <div class="container2">
                                    <form method="post" id="formw">
                                        <fieldset class="title-form">
                                            <legend class="legend-txt"><label for="title"><strong>제목 <span class="wf-red">*</span></strong></label></legend> 
                                            <input type="text" class="textbox" id="title">
                                        </fieldset>
                                        <fieldset class="writter-form">
                                            <legend class="legend-txt"><label for="writter"><strong>작성자 <span class="wf-red">*</span></strong></label></legend>
                                            <input type="text" class="textbox" id="writter" value="운영자" readonly="readonly">
                                        </fieldset>
                                        <fieldset class="content-form">
                                            <legend class="legend-txt"><label for="contents"><strong>내용 <span class="wf-red">*</span></strong></label></legend>
                                            <textarea name="" id="contents" cols="100" rows="20"></textarea>
                                        </fieldset>
                                    </form>
                                    
                                </div>
                              </div>
                            </v-container>
                          </v-card-text>

                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="red-darken-1" variant="outlined" @click="close(0)">
                              취소하기
                            </v-btn>
                            <v-btn color="blue-darken-1" variant="outlined" @click="save(0)">
                              저장하기
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
  </v-card>

  
</template>


<script>

export default {
  name: "notice",
  components: {
    
  },
  data() {
    return {
      dialog: false,
      detailNotice: false,
      updateNotice: false,

    }
  },

  computed : {
    formTitle() {
      return this.editedIndex === -1 ? '글 추가' : '글 수정'
    },
  },
  watch: {
      dialog(val) {
        val || this.close(1)
      },
      detailNotice(val) {
        val || this.close(3)
      },
      updateNotice(val){

        val || this.close(2)
      }
    },

  created() {
  },

  methods: {


    close(num) {
      if (num == 0) {
        this.dialog = false
      }
      if (num == 1) {
        this.updateNotice = false
      }
      if(num ==2) {
        this.detailNotice = false
      }
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save() {
      
      this.close()
    },
    close2() {
      this.detailNotice = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save2() {
      
      this.close()
    },
  },
  
}
</script>

<style scoped>

  
 /* 헤더 스타일 */
.header {
  width: auto;
  height: 115px;
  padding: 20px;
  display: flex;
  text-align: center;
  background: #f5eae3;
  border-bottom: 5px double #fff;
}

  
.menu {
  
  width: 100%;
  justify-content: center;
  margin: auto;
}
  
/* 메뉴 목록 스타일 */
.menu .menu-ulTable {
  margin-right: 7%;
  list-style: none;
  float: right;
}

/* 메뉴 항목 스타일 */
.menu ul li {
  display: inline;
  margin-left: 30px;
  font-size: 1.9rem;
}

/* 메뉴 항목 링크 스타일 */
.menu ul li a {
  text-decoration: none;
  color: black;
}

/* 게시판이 있는 본문 영역 */

/* 메인 */
.main {
  /* height: 100%; */
  text-align: center;
  width: 100%;
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  background-color: #fff;
  /* box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); */
  border-radius: 7px;
  font-family: "GmarketSansTTFMedium";
}

.title {
  padding-top: 30px;
  font-size: 33px;
}

.title h1 {
  margin-bottom: 55px;
}



.board-search .container .search-window {
    padding: 15px 0;
    background-color: #DCDCDC;
    /* border-top: 2px solid #aaa;
    border-bottom: 2px solid #aaa; */
    
  
}


.board-search .form-select,
.board-search .form-input,
.board-search .form-btn {
    height: 30px; /* 높이 조절 */
    font-size: 16px; /* 폰트 크기 조절 */
    border-radius: 10px; /* 4개의 코너에 동일한 크기의 반지름을 적용 */
    border: none;
    display: inline-block;
}

.form-select, .form-input{
  background-color: #fff;
}

.board-search .form-select {
  text-align: center;
  width: 150px; /* 선택 상자 너비 조절 */
  margin-right: 10px; /* 선택 상자와 다른 입력 필드 간의 간격 조절 */
}

.board-search .form-input {
  padding-left: 5px;
  width: 300px; /* 검색어 입력 필드 너비 조절 */
  margin-right: 10px; /* 입력 필드와 검색 버튼 간의 간격 조절 */
}

.board-search .form-btn {
  width: 65px; /*검색 버튼 너비 조절 */
  background-color: #aaa;
  color: white;

}

.form-btn:active {
  /* inset은 그람자를 요소의 안쪽에 만들도록 지정  inset 가로이동 세로이동 흐림정도 색상*/
  box-shadow: inset -.5rem -.1rem 1.2rem #948d8d, inset .3rem .4rem .8rem #918686; 
  color: black;
  cursor: pointer;
}

.ulTable {
  margin-left: auto;
  margin-right: auto;
  height: 35px;
  display: flex;
  
  border-bottom: 1px solid black;
  
}


.ulTable li{

  justify-content: center;
  margin: auto;
  list-style: none;
  
  border-top: none;
}

.ulTable .table_no {
  width: 7%;
}

.ulTable .table_title, .ulTable .table_li_title {
  width: 40%;
}

.table_li_title {
  text-align: left;
}



.ulTable .table_writer{
  width: 20%;
}

.ulTable .table_date {
  width: 13%;
}

.ulTable .table_view {
  width: 8%;
}

.board-list, .board-search{
  overflow-x: auto;
  white-space: nowrap;
}


#font {
  font-weight: bold;
}

.container {
  width: 83%;
  margin-left: auto;
  margin-right: auto;
}

.page{
  margin: 15px;
}

.page-num {
  margin-top: 20px;
  width: 30px;
  display: inline-block;
  
}

.write-btn {
  float: right;
}

.btn {
  min-width: 80px;
  height: 32px;
  border: 1px solid rgb(182, 182, 223);
  border-radius: 8px;
  color: #fff;
  background-color: rgb(48, 41, 41);
  transform: scale(1.1);
  cursor: pointer;
  

}

.btn:hover {
  background-color: #fcf5fc;  
  color: rgb(20, 19, 65);
}

/** 게시글 작성 부분 */
#wrap {
    width: 1200px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 4px;
    /* width: 100%; */
    
    /* border: 1px double black; */
}

.big-title {
    
    width: auto;
    height: 20px;
    padding: 10px;
    margin-bottom: 30px;
    margin-left: 25px;
    float: left;
}

.big-title h2 {
    /* font-family: 'Courier New', Courier, monospace; */
    font-size: 2.5rem;

    
}

.check {
    padding: 0;
    display: inline-block;
    margin-top: 40px;
    margin-bottom: 25px;
    
}


.Btn {
    width: 700px;
    display: inline-block;
    text-align: right;
}

button:hover {
    cursor: pointer;
}

.container2 {
    
    width: 70%;
    margin-left: 100px;
}

.title-form {
    padding: 10px;
    width: max-content;
    margin-bottom: 15px;
}

.legend-txt {
    padding: 2px;
    font-size: 1.1rem;
}

.textbox {
    height: 25px;
    border: 0;
    font-size: 1.3rem;
    border-radius: 5px;
}
.title-form .textbox {
    width: 550px;
}

input:focus {
    outline: none;
}

.writter-form {
    padding: 5px;
    width: max-content;
    margin-bottom: 15px;
    background-color: #d3d3d3;
}
.writter-form legend {
    margin-left: 5px;
    margin-right: 5px;
    background: rgba(255, 255, 255, 0.9);
    border-radius: 10px;
}
.writter-form input{
    background-color: #d3d3d3;
}

.content-form {
    padding: 10px;
    width: max-content;
    margin-bottom: 15px;

}



.Btn button{
    
    border: none;
    border-radius: 10px;
    padding: 6px 15px;
    margin: 30px;
    color: white;
    background-color: rgb(59, 59, 59);
    transform: scale(1.5);
    font-style: italic;

    /* 가로, 세로 거리 및 그림자 색상 설정 */
    box-shadow: 3px 3px 5px gray; 
    transition: background-color 0.3s ease;
    
    
}
#registerbtn:hover {
    background-color: rgb(52, 146, 52);
}
#cancelbtn:hover {
    background-color: #e74c3c;
}
#clear-button:hover {
    background-color: rgb(241, 229, 57);
    color: black;
}

textarea {
    border: 0;
    resize: none;
    font-size: 1.15rem;
}

textarea:focus {
    outline: none;
}

fieldset {
    width: auto;
    clear: both;
    border-radius: 15px;
}

.wf-red{
    color: red;
    font-size: 1.2rem;
}

/**. 게시글 상세 페이지 */
.pagetitle {
    text-align: center;
    color: rgb(1, 1, 39);
    width: 100%;
    font-size: 25px;
    margin-left: auto;
    margin-right: auto;
}


table {
    font-size: 16px;
    font-family: "GmarketSansTTFMedium";
    width: 83%;
    border-collapse: collapse;
    margin-top: 20px;
    margin-left: auto;
    margin-right: auto;
}

th, td {
    border: 1px solid #ccc;  
    padding: 15px;
    text-align: left;
}

th {
    background-color: #f5f5f5;  
    font-weight: bold;
}

.first-line-th {
    width: 265px;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}
</style>
