package com.p360.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.p360.Main.pageObject.PO_Main_CoachesPage;
import com.p360.Main.pageObject.PO_Main_HomePage;
import com.p360.Main.pageObject.PO_Main_MovementsPage;
import com.p360.Main.pageObject.PO_Main_WorkoutsPage;
import com.p360.pageObject.PO_HomePage;
import com.p360.pageObject.PO_LoginPage;
import com.p360.testCases.BaseClass;

public class TC_Main_Movements extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Movements() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_MovementsPage m_mp; //m_mp = MAIN MOVEMENT PAGE
	
	//VARIABLES TO ADD MOVEMENT
	String movementName = "Westwook movement "+faker.name().firstName();
	String movementDescription = "movementDescription: "+faker.lorem().paragraph();
	boolean wantToAllowTracking = true;
	boolean wantToAllowModifiedTracking = true;
	boolean hieght = true;
	boolean weight = true;
	boolean reps = true;
	boolean distance = true;
	boolean time = true;
	boolean score = true;
	boolean rounds = true;
	boolean tonnage = true;
	
	
	//TO FIND MOVEMENT FROM THE LIST
	String movementTitle = "WESTWOOK MOVEMENT CONCEPCION";
	String searchKey = "WESTWOOK MOVEMENT CONCEPCION";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;
	
	//ASSIGN WORKOUT TO THE DATE
	String dateValue = "10 October 2023" ;
	String wantToClickOnDateOrDateBox = "dateBox";
	String assingWorkoutName = "Westwook workoutCherise";
	
	//REMOVE ASSIGNED WORKOUT FROM THE DATE
	String dateValue_removedWorkout = "10 October 2023";
	String wantToClickOnDateOrDateBox_removedWorkout = "dateBox";
	String workoutName_removedWorkout = "Westwook workoutCherise";
	String searchKey_removedWorkout = "Westwook workoutCherise";
	int searchKeyColumnIndex_removedWorkout = 1;
	boolean wantToClickOnDeleteBox_removedWorkout = true;
	boolean wantToclickOnFindSearckKey_removedWorkout = false;
	
	
	//TO ADD MOVEMENT
	//@Test(priority = 1)
	public void test_Main_AddMovement() throws Throwable {
		m_mp = callMeBeforePerformAnyAction();
		System.out.println("movementName: "+movementName);
		m_mp.addOrChangeMovement(movementName,movementDescription,wantToAllowTracking, wantToAllowModifiedTracking,hieght, weight, reps,distance,time,score,rounds,tonnage);
	}
	
	//TO UPDATE/CHANGE WORKOUT
	//@Test(priority = 2)
	public void test_Main_UpdateWorkout() throws Throwable {
		test_Main_FindWorkoutFromListAndClickOnThreeDotButton();
		m_mp.addOrChangeWorkout(workoutName,workoutMemberDescription, workoutCaochDescription, workoutPublishDate,workoutLink);
	}
		
		
		
	//TO DEACTIVATE MOVEMENT
	@Test(priority = 3)
	public void test_Main_DeactivateMovement() throws InterruptedException {
		test_Main_FindMovementFromListAndClickOnThreeDotButton();
		m_mp.deactivateMovement();
	}
		
	//TO ACTIVATE MOVEMENT
	@Test(priority = 4)
	public void test_Main_ActivateMovement() throws InterruptedException {
		test_Main_FindMovementFromListAndClickOnThreeDotButton();
		m_mp.activateMovement();
	}	
	
	//TO ASSIGN WORKOUT TO THE DATE
	//@Test(priority = 5)
	public void test_Main_AssignWorkoutToDate() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.assignWorkoutToDate(dateValue,wantToClickOnDateOrDateBox,assingWorkoutName);
	}
		

	//TO REMOVED ASSIGN WORKOUT FROM THE DATE
	//@Test(priority = 6)
	public void test_Main_removedAssignedWorkoutFromDate() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.removeWorkoutFromDate(dateValue_removedWorkout,wantToClickOnDateOrDateBox_removedWorkout,workoutName_removedWorkout,searchKey_removedWorkout,searchKeyColumnIndex_removedWorkout, wantToClickOnDeleteBox_removedWorkout, wantToclickOnFindSearckKey_removedWorkout);
	}
	
	
	
	
	//TO FIND MOVEMENT AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindMovementFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.findMovementFromListAndClickOnThreeDotButton(movementTitle, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_MovementsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabMovement();
		Thread.sleep(5000);
		return new PO_Main_MovementsPage(driver);	
	}
	
}
