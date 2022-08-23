package base;

import api.impl.ViewAttractionList;
import api.impl.ViewDetailAttraction;
import api.impl.ViewDetailFestival;
import api.impl.ViewDetailStore;
import api.impl.ViewFestivalList;
import api.impl.ViewSearchFestival;
import api.impl.ViewSearchGugunAttraction;
import api.impl.ViewSearchNameAttraction;
import api.impl.ViewSearchStore;
import api.impl.ViewStoreList;
import impl.AdminGongiInsert;
import impl.AdminGongiUdate;
import impl.AdminGongiUdateView;
import impl.UserGetMemberView;
import impl.UserGongView;
import impl.UserGongiList;
import impl.UserJoin;
import impl.UserJoinInsert;
import impl.UserLogin;
import impl.UserQnaDelete;
import impl.UserQnaInsert;
import impl.UserQnaList;
import impl.UserQnaUdate;
import impl.UserQnaUdateView;
import impl.UserQnaView;
import impl.UserReviewInsert;
import impl.UserReviewList;
import impl.UsersMemberList;

public class ActionFactory {

	public Action getAction(String command) {
		
		Action   action = null;
		switch (command) {
		case "USER": // 로그인
			action = new UserLogin();
			break;
		case "JOIN": // 회원가입
			action = new UserJoin();
			break;
		case "JOININSERT": // 회원추가
			action = new UserJoinInsert();
			break;
			
		case "GONGI": // 공지사항
			action = new UserGongiList();
			break;
		case "GONGIVIEW": // 공지상세정보
			action = new UserGongView();
			break;
		case "QNA": // Q&A
			action = new UserQnaList();
			break;
		case "QNAVIEW": // Q&A 상세정보
			action = new UserQnaView();
			break;
		case "QNAINSERT": // Q&A 글쓰기
			action = new UserQnaInsert();
			break;
		case "QNAUPDATEVIEW": // Q&A 수정
			action = new UserQnaUdateView();
			break;
		case "QNAUPDATEA": // Q&A 수정하기
			action = new UserQnaUdate();
			break;
		case "QNADELETE": // Q&A 글쓰기 삭제
			action = new UserQnaDelete();
			break;
			
//-----------------------------------------------------------------------------
			
		case "STORELIST" : // 맛집 목록
			action = new ViewStoreList();
			break;
		case "FESTIVALLIST" : // 축제 목록
			action = new ViewFestivalList();
			break;	
		case "ATTRACTIONLIST" : // 명소 목록
			action = new ViewAttractionList();
			break;	
			
//상세정보 페이지--------------------------------------------------------------------------	
			
		case "DETAILSTORE" : // 맛집 목록
			action = new ViewDetailStore();
			break;	
		case "DETAILFESTIVLA" : // 맛집 목록
			action = new ViewDetailFestival();
			break;		
		case "DETAILATTRACTION" : // 맛집 목록
			action = new ViewDetailAttraction();
      		break;
			
//-----------------------------------------------------------------------------
			
		case "GETMEMBER" : // 회원 개인 정보
			action = new UserGetMemberView();
			break;	
		case "USERSLIST" : // 회원 관리 리스트
			action = new UsersMemberList();
			break;	
			
//-----------------------------------------------------------------------------
			
		case "REVIEW" : // 리뷰 리스트
			action = new UserReviewList();
			break;	
		case "REVIEWINSERT" : // 리뷰 추가
			action = new UserReviewInsert();
			break;	
			
//검색------------------------------------------------------------------------------------			
		case "SEARCHSTORE" : // 맛집 검색
			action = new ViewSearchStore();
			break;		
		case "SEARCHFESTIVAL" : // 축제 검색
			action = new ViewSearchFestival();
			break;		
		case "SEARCHNAMEATTRACTION" : // 명소 이름검색
			action = new ViewSearchNameAttraction();
			break;		
		case "SEARCHGUGUNATTRACTION" : // 명소 지역구검색
			action = new ViewSearchGugunAttraction();
			break;		
			
//관리자-----------------------------------------------------------------------------------------
			
		case "GONGIINSERT" : // 관리자 공지 글쓰기
			action = new AdminGongiInsert();
			break;		
		case "GONGIUPDATEVIEW" : // 관리자 공지 수정
			action = new AdminGongiUdateView();
			break;		
		case "GONGIUPDATEA" : // 관리자 공지 수정하기
			action = new AdminGongiUdate();
			break;		
		}
		return action;
	}

}
