var count = 0;
var userAnswers = []; // 用户答案
var pro = {
    'questions': [{
        'question': '1.在新的历史条件下,我们党面临着执政、改革开放、（）、外部环境“四大考验”。',
        'answers': ['A.商品经济', 'B.内部环境', 'C.市场经济', 'D.执政能力'],
        'correctAnswer': 3,
        'tureAnswer': 'C'
    }, {
        'question': '2.在新的历史条件下,我们党面临着精神懈怠、能力不足、（）、消极腐败“四大危险”。',
        'answers': ['A.贪污腐败', 'B.脱离群众', 'C.思想堕落', 'D.执政经验欠缺'],
        'correctAnswer': 2,
        'tureAnswer': 'B'
    }, {
        'question': '3.全面提高党的建设科学化水平,全党要增强紧迫感和责任感,牢牢把握的主线是（）',
        'answers': ['A.加强党的执政能力建设', 'B.加强先进性、纯洁性建设和党的执政能力建设', 'C.加强先进性和纯洁性建设', 'D.加强党的执政能力建设、先进性和纯洁性建设'],
        'correctAnswer': 4,
        'tureAnswer': 'D'
    }, {
        'question': '4.不断提高党的领导水平和执政水平、提高（）能力,是党巩固执政地位、实现执政使命必须解决好的重大课题。',
        'answers': ['A.依法执政和民主执政', 'B.科学发展', 'C.拒腐防变和抵御风险', 'D.治国理政'],
        'correctAnswer': 3,
        'tureAnswer': 'C'
    }]

};
function init() {

    var q_div = document.getElementById('question');
    var a_div = document.getElementById('answer');
    var n_div = document.getElementById('number');

    var ques = document.createTextNode(pro.questions[count].question);
    var num = document.createTextNode(count + 1 + '/' + pro.questions.length);
    //q_div.appendChild(ques);
    n_div.appendChild(num);
    var questionValue = document.getElementById("question").innerHTML;
    questionValue = questionValue.replace("", pro.questions[count].question);
    document.getElementById("question").innerHTML = questionValue;

    for (var i = 0; i < pro.questions[count].answers.length; i++) {
        //var ans = document.createTextNode(pro.questions[count].answers[i]);
        var li_node = document.createElement('li');
        var ans = li_node.innerHTML;
        ans = ans.replace("",pro.questions[count].answers[i]);
        li_node.innerHTML = ans;
        a_div.appendChild(li_node);
    }
}

//下一题
function next() {

    //获取用户的选项
    userAnswers[count] = $('ul').find('li.selected').text().toString().substr(0,1);

    //如果没有选择，则不允许点击下一题
    if ($('ul').find('li.selected').length === 0) {
        return false;
    }

    //判断是否为最后一题
    if((pro.questions.length-1) == count) {
        alert(userAnswers.toString());
        return false;
    }



    //上一题题目
    var titleName = pro.questions[count].question;

    // 更换题目
    var questionValue = document.getElementById("question").innerHTML;
    questionValue = questionValue.replace(titleName, pro.questions[++count].question);
    document.getElementById("question").innerHTML = questionValue;

    //更换选项,先把ul标签下的li标签全部清除，重新创建
    var a_div = document.getElementById('answer');
    $("ul").find("li").remove();
    for (var i = 0; i < pro.questions[count].answers.length; i++) {
        var li_node = document.createElement('li');
        var ans = li_node.innerHTML;
        ans = ans.replace("",pro.questions[count].answers[i]);
        li_node.innerHTML = ans;
        a_div.appendChild(li_node);
    }


}

//上一题
function pre() {

    //判断是否是第一题，如果是，不允许点上一题
    if(0 == count) {
        return false;
    }

    //上一题题目
    var titleName = pro.questions[count].question;

    // 更换题目
    var questionValue = document.getElementById("question").innerHTML;
    questionValue = questionValue.replace(titleName, pro.questions[--count].question);
    document.getElementById("question").innerHTML = questionValue;

    //更换选项,先把ul标签下的li标签全部清除，重新创建
    var a_div = document.getElementById('answer');
    $("ul").find("li").remove();
    for (var i = 0; i < pro.questions[count].answers.length; i++) {
        var li_node = document.createElement('li');
        var ans = li_node.innerHTML;
        ans = ans.replace("",pro.questions[count].answers[i]);
        li_node.innerHTML = ans;
        a_div.appendChild(li_node);
    }
}

//触发选择按钮
$('#answer').delegate("li","click",function(){
    var thisLi = $(this);
    thisLi.parents('#answer').children('li').removeClass('selected');
    thisLi.addClass('selected');
});

//初始化
init();