var count = 0;
var userAnswers = []; // 用户答案
var singleSelect = [ 0, 10, 11, 12, 13, 14, 15, 22, 23, 24, 28]; // 单选题
var pro = {
	'questions' : [
			{
				'question' : '1. 近期学校将要接受教育部什么评估？评估的具体时间？',
				'answers' : [ 'A.审核评估   2017年12月18日至12月21日',
						'B.审核评估   2017年12月19日至12月22日' ],
			},
			{
				'question' : '2.教育部本科教学评估有哪几种类型？审核评估有何不同？（多选）',
				'answers' : [ 'A.合格评估、水平评估和审核评估', 'B.合格评估、教育评估和审核评估',
						'C.合格评估、水平评估是教育部用同一把尺子量所有学校',
						'D.审核评估是教育部用被评学校“自己的尺子量自己' ],
			},
			{
				'question' : '3.哪些高校要参加本科教学工作审核评估？（多选）',
				'answers' : [ 'A.参加2003-2008 年普通高等学校本科教学工作水平评估获得“合格”及以上结论的高校',
						'B.参加普通高等学校本科教学工作合格评估获得“通过”结论的新建本科院校，5年后须参加审核评估',
						'C.参加2004-2009 年普通高等学校本科教学工作水平评估获得“合格”及以上结论的高校',
						'D.参加普通高等学校本科教学工作合格评估获得“通过”结论的新建本科院校，3年后须参加审核评估' ],
			},
			{
				'question' : '4.本科教学工作审核评估的二十字方针是什么？（多选）',
				'answers' : [ 'A.以评促建', 'B.以评促改', 'C.以评促管', 'D.评建结合', 'E.重在建设' ],
			},
			{
				'question' : '5.本科教学工作审核评估重点考察什么？（多选）',
				'answers' : [ 'A.学校人才培养效果与培养目标的达成度',
						'B.学校办学定位和人才培养目标与社会需求的适应度', 'C.教师和教学资源对学校人才培养的保障度',
						'D.教学质量保障体系运行的有效度', 'E.学生和用人单位的满意度' ],
			},
			{
				'question' : '6.本科教学工作审核评估的意义与目的是什么？（多选）',
				'answers' : [ 'A.督促高校按国家规定的质量标准办学', 'B.提高本科教学质量保障水平',
						'C.引领高校科学定位、分类合作、多元发展、特色办学', 'D.提高教育部对学校的管理力度' ],
			},
			{
				'question' : '7.开展本科教学工作审核评估对提高高校教学质量有何作用？（多选）',
				'answers' : [
						'A.开展本科教学工作审核评估是提高高等教育质量的重要抓手',
						'B.能鉴定学校教学工作的质量和水平，诊断学校教学工作存在的问题并提出改进建议',
						'C.	发挥评估指标的导向作用，引导学校更新教育观念、明确发展方向和目标、深化教学改革，推动产学合作教育深入开展',
						'D.评估具有激励和督促作用，能够促进学校不断改善办学条件、加强教学管理、建立并完善内部质量保障体系、形成自我约束和监控机制' ],
			},
			{
				'question' : '8.本科教学工作审核评估对学生有何影响？（多选）',
				'answers' : [
						'A.评估将进一步促使高校加大本科教学的投入，改善校园环境，加强教学管理，保证教学质量',
						'B.评估将进一步促进学校加大师资力量建设、课程建设、学风建设的力度，促进学校提高办学硬件和育人环境，广大学生将会得到更优质的教育',
						'C.评估结果将直接关系到学生今后的发展',
						'D.评估取得好成绩，将会极大提高我校的社会形象和地位，将会进一步增强广大学生和家长的求学和送学信心，吸引更多的用人单位来我校招聘毕业生，创造更多的就业机会和更高的就业层次' ],
			},
			{
				'question' : '9.学生应该怎样积极参与学校的迎评工作？（多选）',
				'answers' : [ 'A.上课、自习状况优良', 'B.行为文明、形象端庄', 'C.努力打造“文明宿舍”',
						'D.全面了解评估知识,对学校有高度的认同感',
						'E.在校园内遇见专家时要主动问好、文明礼让,了解和专家接触的各种方式,随时准备参加专家主持的问卷调查或座谈会' ],
			},
			{
				'question' : '10.学校历史沿革如何？（多选）',
				'answers' : [ 'A.办学溯源于1905年创办的江西实业学堂，1908年更名为江西高等农业学堂',
						'B.1943年更名江西省立农业专科学校，1949年并入南昌大学农学院',
						'C.本科教育肇始于1940年创办的国立中正大学，1949年更名为南昌大学',
						'D.1952年以南昌大学农学院农学专业、兽医专业为主体组建江西农学院',
						'E.1958年创办江西共产主义劳动大学总校，1968年更名为江西共产主义劳动大学',
						'F.1969年江西农学院并入江西共产主义劳动大学。1980年更名为江西农业大学' ],
			},
			{
				'question' : '11.学校占地面积多少？',
				'answers' : [ 'A.1.5万亩', 'B.1.6万亩', 'C.1.7万亩', 'D.1.8万亩' ],
			},
			{
				'question' : '12.学校现任党委书记、校长分别是谁？',
				'answers' : [ 'A.黄路生、赵小敏', 'B.赵小敏、黄路生' ],
			},
			{
				'question' : '13.我校的校训是什么？',
				'answers' : [ 'A.团结、勤奋、求实、创新', 'B.厚德、博学、抱朴、守真' ],
			},
			{
				'question' : '14.我校的精神是什么？',
				'answers' : [ 'A.团结、勤奋、求实、创新', 'B.厚德、博学、抱朴、守真' ],
			},
			{
				'question' : '15.学校学生规模情况如何？',
				'answers' : [ 'A.各类全日制在校学生21434人，其中全日制本科生19685人',
						'B.各类全日制在校学生22434人，其中全日制本科生19685人' ],
			},
			{
				'question' : '16.学校有多少个教学单位？',
				'answers' : [ 'A.16', 'B.17' ],
			},
			{
				'question' : '17.学校学科与专业总体情况如何？（多选）',
				'answers' : [ 'A.学科涵盖农、理、工、经、管、文、法、教、艺等9大门类',
						'B.有3个一级学科博士点、17个二级学科博士点', 'C.19个一级学科硕士点、78个二级学科硕士点',
						'D.68个本科专业' ],
			},
			{
				'question' : '18.学校的办学思想是什么？（多选）',
				'answers' : [ 'A.立足江西、服务华东、面向全国、融入国际，助推区域经济社会发展，支撑乡村振兴战略',
						'B.以本科教育为主体，积极发展研究生教育，适度开展继续教育，大力拓展留学生教育和多种形式的合作办学',
						'C.建成行业内有重要影响、综合实力省内前列、优势学科国内一流的有特色高水平教学研究型大学' ],
			},
			{
				'question' : '19.学校的办学特色是什么？（多选）',
				'answers' : [ 'A.坚守“有特色高水平教学研究型大学”的办学定位',
						'B.坚持“基础宽厚实，专业精新活”的办学要求',
						'C.培养具有优秀品德、现代视野、专业技能、创新精神、创业能力的复合型人才' ],
			},
			{
				'question' : '20.学校的办学定位是什么？（多选）',
				'answers' : [
						'A.建成行业内有重要影响、综合实力省内前列、优势学科国内一流的有特色高水平大学',
						'B.教学研究型大学',
						'C.以本科教育为主体，积极发展研究生教育，适度开展继续教育，大力拓展留学生教育和多种形式的合作办学',
						'D.以农为优势，以生物技术为特色，多学科协调发展',
						'E.坚持立德树人，按照“加强基础、拓宽口径、注重素质、提高能力”要求，培养德智体美全面发展，具有优秀品德、现代视野、专业技能、创新精神、创业能力的复合型人才',
						'F.立足江西、服务华东、面向全国、融入国际，助推区域经济社会发展，支撑乡村振兴战略' ],
			},
			{
				'question' : '21.学校本科人才培养总目标是什么？（多选）',
				'answers' : [ 'A.加强基础，拓宽口径，注重素质，提高能力',
						'B.促进学生德、智、体、美全面发展，努力培养能适应国家经济建设和社会发展需要',
						'C.具有优秀品德、现代视野、专业技能、创新精神和创业能力的复合型人才' ],
			},
			{
				'question' : '22.学校在哪些方面体现了人才培养的中心地位？（多选）',
				'answers' : [ 'A.领导重视，强化教学中心地位', 'B.政策引领，引导教师潜心教学',
						'C.完善制度，确保培养目标达成', 'D.投入优先，保障教育教学条件' ],
			},
			{
				'question' : '23.学校教师队伍状况如何？',
				'answers' : [ 'A.专任教师992人，专职辅导员78人，实验技术人员111人，外聘教师429人',
						'B.专任教师962人，专职辅导员78人，实验技术人员111人，外聘教师430人' ],
			},
			{
				'question' : '24.学校生师比是多少？',
				'answers' : [ 'A.19.2:1', 'B.17.2:1' ],
			},
			{
				'question' : '25.学校共有多少间教室？',
				'answers' : [ 'A.560间', 'B.580间 ' ],
			},
			{
				'question' : '26.学校实践教学设施建设情况如何？（多选）',
				'answers' : [ 'A.学校实践教学设施齐全', 'B.学校实践教学设施不齐全', 'C.有教学实验室46个' ],
			},
			{
				'question' : '27.学校图书馆建设情况如何？（多选）',
				'answers' : [ 'A.校图书馆由老馆（北区）、逸夫馆（南区）和东区图书馆组成',
						'B.图书馆馆藏纸质图书和电子图书共计近300万册', 'C.实现了免费无线网络全覆盖',
						'D.学校的标志性建筑' ],
			},
			{
				'question' : '28.学校现有体育设施情况如何？（多选）',
				'answers' : [ 'A.学校各类运动场地共45个', 'B.场所面积累计达到10.8万多平方米',
						'C.均配有比较完善的相关设施及器材', 'D.但不能满足全体师生体育教学和课外训练的需要' ],
			},
			{
				'question' : '29.学校课程体系是怎样的？',
				'answers' : [ 'A.以专业课程为基础', 'B.为通识课程、学科基础课程主干',
						'C.选修课程为延伸的课程结构' ],
			},
			{
				'question' : '30.学校合作办学情况如何？（多选）',
				'answers' : [
						'A.已经同澳大利亚纽卡斯尔大学、英国埃塞克斯大学、美国密西西比州立大学等国外高校开展了校际合作',
						'B.同澳大利亚西澳大学、泰国清迈大学、泰国玛希隆大学、马来西亚沙巴大学等国（境）外高校及科研院所等达成合作意向',
						'C.我校软件工程实行“3+1”人才培养模式',
						'D.与江西省婺源茶叶学校举行了“2+1+1”合作办学，针对茶学、旅游管理等专业人才培养，开展合作交流' ],
			},
			{
				'question' : '31.学校是如何开展人才培养机制、人才培养模式改革的？（多选）',
				'answers' : [ 'A.优化人才培养方案', 'B.健全人才培养体制', 'C.丰富人才培养途径' ],
			},
			{
				'question' : '32.学校在课堂教学改革方面有哪些举措？（多选）',
				'answers' : [ 'A.以研促教，丰富课堂教学资源',
						'B.以研促教，丰富课堂教学资源狠抓集体备课，深化课堂教学改革理念' ],
			},
			{
				'question' : '33.学校在评价学生学习效果方面有哪些举措？（多选）',
				'answers' : [ 'A.强化考核过程管理', 'B.丰富课程考核方法', 'C.严肃课程考核纪律' ],
			},
			{
				'question' : '34.学校实践教学体系是什么？（多选）',
				'answers' : [ 'A.认知与基础—体验与综合—研究与创新”循序渐进分层次、分阶段',
						'B.一、二年级重在通过课程学习，了解科学研究前沿，提高基本认知',
						'C.二、三年级进实验室开展基本训练和综合体验',
						'三、四年级在导师引领下进入科研团队开展系统科学研究创新，完成毕业论文' ],
			},
			{
				'question' : '35.学校的第二课堂育人体系是什么？（多选）',
				'answers' : [ 'A.以激发学生的主体性与创造性为目标', 'B.以提升学生的能力和素质为导向',
						'C.以文化活动、创新创业、社团建设、社会实践、志愿服务、国内外交流访问等为主要内容的第二课堂育人体系' ],
			},
			{
				'question' : '36.学校建立了什么样的学生指导与帮扶体系？（多选）',
				'answers' : [
						'A.设置学生心理健康教育与咨询中心、学生资助管理中心、学生就业指导中心，形成“教师辅导员+班主任+学生辅导员+本科生导师”为主体的学生指导帮扶队伍',
						'B.规定教师晋升更高一级职称必须有班主任工作经历',
						'C.采用“2+3”模式选拔优秀本科生保送研究生担任辅导员',
						'D.形成了辅导员与学生“同住学生公寓、同吃学生食堂、同学理论知识、同开展社会实践、同组织课外活动”的“五同”工作模式' ],
			},
			{
				'question' : '37.学校总体学习风气如何？（多选）',
				'answers' : [ 'A.学生遵章守纪、勤奋学习、积极向上的学习氛围', 'B.考试作弊现象严重，高缺课率',
						'C.低补考率、低违纪率、低留级率、低休学率、低退学率', 'D.教师爱岗敬业、教学秩序井然' ],
			},
			{
				'question' : '38.学校在加强学风建设方面采取了什么样的政策措施？（多选）',
				'answers' : [ 'A.深化教学体制改革、完善教学管理制度', 'B.放松日常教学秩序、营造优良校风学风',
						'C.严肃考风考纪、发挥榜样示范作用', 'D.不断加强学风建设、完善学业预警和干预制度' ],
			},
			{
				'question' : '39.学校毕业生的就业情况如何？（多选）',
				'answers' : [ 'A.我校本科生就业率相对稳定', 'B.我校就业情况不乐观，需要改进',
						'C.我校本科就业率位居全省高校前列',
						'D.2015-2017届本科毕业生平均就业率87.85%、平均升学率10.32%，外省就业40%以上' ],
			},
			{
				'question' : '40.学校采取了哪些毕业生就业保障服务措施？（多选）',
				'answers' : [ 'A.完善就业两级工作体系', 'B.实施就业分类精准指导', 'C.夯实就业择业保障机制',
						'D.倡导毕业生自主择业' ],
			},
			{
				'question' : '41.学校建立了怎样的人才培养质量保障体系？（多选）',
				'answers' : [ 'A.坚持“学者为本、学生至上、学院主体”的管理服务理念',
						'B.弱化监测跟踪与反馈是质量保障体系的重要内容', 'C.人才培养质量保障与资源要素的配置和培养剥离',
						'D.不断完善“决策管理、质量监控、评价激励、信息反馈”四位一体的人才培养质量保障体系' ],
			},
			{
				'question' : '42.学校构建了怎样的教学质量监控体系？（多选）',
				'answers' : [ 'A.一个基于人才培养目标、涵盖各主要教学环节的体系',
						'B.从质量标准确立、信息收集与分析评价过程的体系', 'C.一个运行存在问题的教学质量监督体系',
						'D.信息反馈调控、约束激励的“全过程跟踪式”教学质量监控体系' ],
			},
			{
				'question' : '43.学校采集教学质量信息的途径有哪些？（多选）',
				'answers' : [ 'A.座谈会、教学检查', 'B.教学督导、干部听课', 'C.学生评教、教师评学',
						'D.学生信息员、学生满意度调查和毕业生跟踪调查' ],
			},
			{
				'question' : '44.学校教学质量改进的机制是什么？（多选）',
				'answers' : [ 'A.学校形成了教学工作规范与教学质量标准同步的改进机制',
						'B.教学质量管理与教学质量监控并重的改进机制', 'C.教学激励政策与教学质量改进挂钩的改进机制' ],
			},
			{
				'question' : '45.学校的办学特色是指什么？（多选）',
				'answers' : [ 'A.办学特色是指一所学校与其他学校相比较所表现出来的独特的办学内涵',
						'B.高校的办学特色的定位是形成办学多样化的有效途径', 'C.办学特色是无意识的培育出来的',
						'D.高校在教育市场中具有竞争力的表现' ],
			},
			{
				'question' : '46.我校的特色项目是什么？（多选）',
				'answers' : [ 'A.“三三三”模式的实践教育特色',
						'B.突出生产教学实践、科技服务实践、社会调研实践“三实践”',
						'C.依托教学实践基地、科技服务项目、学生社团活动“三平台”',
						'D.强化第一课堂与第二课堂、校内实践与校外实践、教育培养与服务社会“三结合”' ],
			},
			{
				'question' : '47.“三三三”模式的主要成效如何？（多选）',
				'answers' : [ 'A.完善了大学生实践教学体系,推动了实践教学师资队伍建设',
						'B.提升了大学生科技活动的技术含金量,提高了大学生素质能力', 'C.带动了大学生就业率和就业质量',
						'D.实现了教育培养和服务社会的结合' ],
			} ]

};
function init() {

	var q_div = document.getElementById('question');
	var a_div = document.getElementById('answer');
	var n_div = document.getElementById('number');

	var ques = document.createTextNode(pro.questions[count].question);
	var num = document.createTextNode(count + 1 + '/' + pro.questions.length);
	// q_div.appendChild(ques);
	n_div.appendChild(num);
	var questionValue = document.getElementById("question").innerHTML;
	questionValue = questionValue.replace("", pro.questions[count].question);
	document.getElementById("question").innerHTML = questionValue;
	// 添加单选标识
	$("#question").attr("single-select", count);
	for (var i = 0; i < pro.questions[count].answers.length; i++) {
		// var ans = document.createTextNode(pro.questions[count].answers[i]);
		var li_node = document.createElement('li');
		var ans = li_node.innerHTML;
		ans = ans.replace("", pro.questions[count].answers[i]);
		li_node.innerHTML = ans;
		a_div.appendChild(li_node);

	}

	$("#answer li").each(function(i) {
		$(this).attr("data-select", i);
	});
}
// 初始化
init();
// 下一题
function next() {

	// 获取用户的选项
	var strans = [];
	$("#answer .selected").each(function(i) {
		strans.push($(this).attr("data-select"));
	});
	userAnswers[count] = strans.join("");
	// 如果没有选择，则不允许点击下一题
	if ($('ul').find('li.selected').length === 0) {
		$('p').css('color', 'red');
		return false;
	} else {
		$('p').css('color', 'white');
	}

	// 判断是否为最后一题
	if ((pro.questions.length - 1) == count) {
		var params = {
			"method" : "submit",
			"userAnswers" : userAnswers
		};
		httpPost($("#baseUrl").val() + "/user", params);
	}

	// 上一题题目
	var titleName = pro.questions[count].question;

	// 更换题目
	var questionValue = document.getElementById("question").innerHTML;
	questionValue = questionValue.replace(titleName,
			pro.questions[++count].question);
	document.getElementById("question").innerHTML = questionValue;
	// 如果单选题数组中包含该题号
	for(var k = 0; k < singleSelect.length; k++){
		if (count == singleSelect[k]) {
			// 添加单选标识
			$("#question").attr("single-select", count);
			break;
		} else {
			// 删除单选标识
			$("#question").removeAttr("single-select");
		}
    }
	
	// 更换选项,先把ul标签下的li标签全部清除，重新创建
	var a_div = document.getElementById('answer');
	$("ul").find("li").remove();
	for (var i = 0; i < pro.questions[count].answers.length; i++) {
		var li_node = document.createElement('li');
		var ans = li_node.innerHTML;
		ans = ans.replace("", pro.questions[count].answers[i]);
		li_node.innerHTML = ans;
		a_div.appendChild(li_node);
	}
	// 更换题目标号
	if (count < pro.questions.length) {
		var questionNum = document.getElementById('number');
		questionNum.innerHTML = count + 1 + '/' + pro.questions.length;
	}
	$("#answer li").each(function(i) {
		$(this).attr("data-select", i);
	});
}

// 上一题
function pre() {

	// 判断是否是第一题，如果是，不允许点上一题
	if (0 == count) {
		return false;
	}

	// 上一题题目
	var titleName = pro.questions[count].question;

	// 更换题目
	var questionValue = document.getElementById("question").innerHTML;
	questionValue = questionValue.replace(titleName,
			pro.questions[--count].question);
	document.getElementById("question").innerHTML = questionValue;
	// 如果单选题数组中包含该题号
	for(var k = 0; k < singleSelect.length; k++){
		if (count == singleSelect[k]) {
			// 添加单选标识
			$("#question").attr("single-select", count);
			break;
		} else {
			// 删除单选标识
			$("#question").removeAttr("single-select");
		}
    }
	
	// 更换选项,先把ul标签下的li标签全部清除，重新创建
	var a_div = document.getElementById('answer');
	$("ul").find("li").remove();
	for (var i = 0; i < pro.questions[count].answers.length; i++) {
		var li_node = document.createElement('li');
		var ans = li_node.innerHTML;
		ans = ans.replace("", pro.questions[count].answers[i]);
		li_node.innerHTML = ans;
		a_div.appendChild(li_node);
	}
	// 更换题目标号
	if (count < pro.questions.length) {
		var questionNum = document.getElementById('number');
		questionNum.innerHTML = count + 1 + '/' + pro.questions.length;
	}
	$("#answer li").each(function(i) {
		$(this).attr("data-select", i);
	});
}

// 触发选择按钮
$('#answer').delegate(
		"li",
		"click",
		function() {
			var thisLi = $(this);
			
			var single = $(this).parent().parent().siblings().children(
					"#question").attr("single-select");
			// 表示是多选
			if (single == undefined) {
				if (thisLi.hasClass('selected')) {
					thisLi.removeClass('selected');
					thisLi.removeClass('updata');
				} else {
					thisLi.addClass('selected');
					thisLi.addClass('updata');
				}
			}else {
				 thisLi.parents('#answer').children('li').removeClass('selected updata');
				 thisLi.parents('#answer').children('li').removeClass('selected updata');
				 thisLi.addClass('selected');
				 thisLi.addClass('updata');
			}

		});

// 实现post请求
function httpPost(URL, PARAMS) {
	var temp = document.createElement("form");
	temp.action = URL;
	temp.method = "post";
	temp.style.display = "none";

	for ( var x in PARAMS) {
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = PARAMS[x];
		temp.appendChild(opt);
	}

	document.body.appendChild(temp);
	temp.submit();

	return temp;
}
