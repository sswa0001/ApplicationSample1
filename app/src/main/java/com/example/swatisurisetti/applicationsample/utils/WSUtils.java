package com.example.swatisurisetti.applicationsample.utils;

public class WSUtils {

	// public static final String LOCAL_URL =
	// "http://local.configure.it/my_medical_portfolio_new/WS/";

	public static final String LOCAL_URL = "http://192.168.43.4/my_medical_portfolio_new/WS/";

	//public static final String LIVE_URL = "http://52.76.15.197/WS/";
	public static final String LIVE_URL = "http://mymedicalportfolio.in/WS/";
	
	public static final String DUMMY_URL = "http://108.170.62.152/webservice/mmp/WS/";
	
	public static final String BASE_URL = LIVE_URL;
	// public static final String BASE_URL =
	// "http://192.168.43.18/my_medical_portfolio_new/WS/";

	/**
	 * @HOME {@link requires}<br>
	 *       user_id<br>
	 */
	public static final String HOME = BASE_URL + "home?";

	/**
	 * @LOGIN {@link requires}<br>
	 *        email_id password <br>
	 *        device_token <br>
	 *        device_type
	 * */

	public static final String LOGIN = BASE_URL + "login?";

	/**
	 * @LOGIN {@link requires}<br>
	 *        user_id<br>
	 *        complaints<br>
	 *        added_date<br>
	 * 
	 * 
	 * */

	public static final String ADDCOMPLAINTS = BASE_URL + "add_complaints?";

	// http://local.configure.it/my_medical_portfolio_new/WS/add_complaints
	/**
	 * @REPORT_WISE_MMP_SHARE_DETAILS {@link requires}<br>
	 *                                user_id <br>
	 *                                report_id <br>
	 *                                send_type <br>
	 *                                person
	 * 
	 * */

	public static final String REPORT_WISE_MMP_SHARE_DETAILS = BASE_URL + "report_wise_mmp_share_details?";

	/**
	 * @CHANGEPASSWORD {@link requires}<br>
	 *                 user_id <br>
	 *                 new_password <br>
	 *                 old_password <br>
	 * 
	 * */

	public static final String CHANGEPASSWORD = BASE_URL + "change_password?";
	/**
	 * @FORGOT_PASSWORD {@link requires}<br>
	 *                  email <br>
	 * 
	 * */

	public static final String FORGOT_PASSWORD = BASE_URL + "forgot_password?";

	/**
	 * @ADDPARAMETER {@link requires}<br>
	 *               user_id <br>
	 *               parameter_id <br>
	 *               current_measurement <br>
	 *               remarks <br>
	 *               upload_test_report <br>
	 *               parameter_date <br>
	 *               person <br>
	 *               parameter_value_id <br>
	 * */

	public static final String ADDPARAMETER = BASE_URL + "add_parameter?";
	/**
	 * @EDITPARAMETER {@link requires}<br>
	 *                user_id <br>
	 *                my_parameter_id <br>
	 *                parameter_id <br>
	 *                parameter_value_Id <br>
	 *                current_measurement <br>
	 *                remarks <br>
	 *                parameter_date <br>
	 *                person <br>
	 *                upload_test_report <br>
	 * */

	public static final String EDITPARAMETER = BASE_URL + "edit_parameter?";

	/**
	 * @CONTACT_LIST
	 * */

	public static final String CONTACT_LIST = BASE_URL + "contact_list?";

	/**
	 * @FILTER_PARAMETER
	 * */

	public static final String FILTER_PARAMETER = BASE_URL + "filter_parameter?";

	/**
	 * @ADDMEDICINE {@link requires}<br>
	 *              user_id <br>
	 *              medicine_date <br>
	 *              person <br>
	 *              medicine_name <br>
	 *              content <br>
	 *              course_start_date <br>
	 *              course_end_date <br>
	 *              medicine_time <br>
	 *              prescription <br>
	 *              remark
	 * */

	public static final String ADDMEDICINE = BASE_URL + "add_medicine?";

	/**
	 * @EDITMEDICINE {@link requires}<br>
	 *               user_id <br>
	 *               medicine_date <br>
	 *               person <br>
	 *               medicine_name <br>
	 *               content <br>
	 *               course_start_date <br>
	 *               course_end_date <br>
	 *               medicine_time <br>
	 *               medicine_time_id <br>
	 *               prescription <br>
	 *               upload_test_report<br>
	 **/

	public static final String EDITMEDICINE = BASE_URL + "edit_medicine?";

	/**
	 * @ADDCONTACT {@link requires}<br>
	 *             user_id <br>
	 *             name <br>
	 *             relation <br>
	 *             gender <br>
	 *             date_ofbirth <br>
	 *             parameter_date <br>
	 *             email <br>
	 *             phone_no <br>
	 *             phone_no <br>
	 *             mobile_no <br>
	 *             >>>>>>> .r101
	 * */

	public static final String ADDCONTACT = BASE_URL + "add_contact?";

	/**
	 * @UPDATECONTACT {@link requires}<br>
	 *                user_id <br>
	 *                contact_id <br>
	 *                name <br>
	 *                relation <br>
	 *                gender <br>
	 *                date_ofbirth <br>
	 *                parameter_date <br>
	 *                email <br>
	 *                phone_no <br>
	 *                phone_no <br>
	 *                mobile_no <br>
	 * */

	public static final String UPDATECONTACT = BASE_URL + "update_contact?";

	/**
	 * @UPDATECONTACT {@link requires}<br>
	 * 
	 * 
	 * */

	public static final String COUNTRY = BASE_URL + "country_drop_down?";
	/**
	 * @Signup {@link requires}<br>
	 *         first_name<br>
	 *         last_name<br>
	 *         birthdate<br>
	 *         gender<br>
	 *         bloodgroup<br>
	 *         country_id<br>
	 *         address<br>
	 *         pin_code<br>
	 *         phone_no<br>
	 *         mobile_no<br>
	 *         email<br>
	 *         password<br>
	 * 
	 * */

	public static final String Drugs = BASE_URL + "get_drug_list?";

	public static final String ALLERGIES = BASE_URL + "get_allergies_list?";

	public static final String GET_FAMILY_HISTORY_LIST = BASE_URL + "get_family_history_list?";

	public static final String SIGNUP = BASE_URL + "sign_up?";

	/**
	 * @my_past_history {@link requires}<br>
	 *                  user_id<br>
	 *                  hospitalization<br>
	 *                  hospitalization_date<br>
	 *                  hospitalization_description<br>
	 *                  surgery<br>
	 *                  surgery_date<br>
	 *                  surgery_description<br>
	 *                  incidence<br>
	 *                  incidence_date<br>
	 *                  incidence_description<br>
	 *                  disease_which_is_continuous<br>
	 *                  medicine_name<br>
	 * 
	 * */
	public static final String MY_PAST_HISTORY = BASE_URL + "my_past_history?";

	/**
	 * @family_wise_my_past_history {@link requires}<br>
	 *                              user_id<br>
	 *                              hospitalization<br>
	 *                              hospitalization_date<br>
	 *                              hospitalization_description<br>
	 *                              surgery<br>
	 *                              surgery_date<br>
	 *                              surgery_description<br>
	 *                              incidence<br>
	 *                              incidence_date<br>
	 *                              incidence_description<br>
	 *                              disease_which_is_continuous<br>
	 *                              medicine_name<br>
	 *                              family_id
	 * 
	 * */
	public static final String FAMILY_WISE_MY_PAST_HISTORY = BASE_URL + "family_wise_my_past_history?";

	/**
	 * @my_personal_history {@link requires}<br>
	 *                      habits<br>
	 *                      addictions<br>
	 *                      allergies<br>
	 *                      drug_reactions<br>
	 *                      user_id<br>
	 *                      allergies_other<br>
	 *                      drug_reactions_other<br>
	 * 
	 * */

	public static final String MYPERSONAL = BASE_URL + "my_personal_history?";
	/**
	 * @MY_FAMILI_HISTORY {@link requires} user_id <br>
	 *                    father <br>
	 *                    father_other<br>
	 *                    mother <br>
	 *                    mother_other<br>
	 *                    brother <br>
	 *                    brother_other <br>
	 *                    sister <br>
	 *                    sister_other
	 * */
	public static final String MYFAMILY_SIGNUP = BASE_URL + "my_family_history?";
	/**
	 * @ADD_FAMILY_MEMBER {@link requires}<br>
	 *                    user_id <br>
	 * */

	public static final String ADD_FAMILY_MEMBER = BASE_URL + "add_family_member?";

	/**
	 * @UPDATE_FAMILY_MEMBER {@link requires}<br>
	 *                       user_id <br>
	 * */

	public static final String UPDATE_FAMILY_MEMBER = BASE_URL + "update_family_member?";

	/**
	 * @FAMILY_DROP_DOWN {@link requires}<br>
	 *                   user_id<br>
	 */
	public static final String FAMILY_DROP_DOWN = BASE_URL + "family_drop_down?";

	/**
	 * @PARAMETER_DROP_DOWN {@link requires}<br>
	 *                      country_id<br>
	 */
	public static final String PARAMETER_DROP_DOWN = BASE_URL + "parameter_drop_down?";

	/**
	 * @PARAMETER_FAMILY_DROP_DOWN {@link requires}<br>
	 *                             user_id<br>
	 */
	public static final String PARAMETER_FAMILY_DROP_DOWN = BASE_URL + "parameter_family_drop_down?";

	/**
	 * @REPORT_DETAILS {@link requires}<br>
	 *                 user_id<br>
	 *                 date_of_reports
	 */
	public static final String REPORT_DETAILS = BASE_URL + "report_details?";

	/**
	 * @PARAMETERS {@link requires}<br>
	 *             user_id<br>
	 *             user_type<br>
	 */

	// public static final String PARAMETERS = BASE_URL + "parameters?";
	public static final String PARAMETERS = BASE_URL + "filter_parameter?";

	/**
	 * @MEDICINES {@link requires}<br>
	 *            user_id<br>
	 *            from_date<br>
	 *            to_date<br>
	 *            persone<br>
	 */
	public static final String MEDICINES = BASE_URL + "medicines?";

	/**
	 * @CONTACTS {@link requires}<br>
	 *           user_id<br>
	 */
	public static final String CONTACTS = BASE_URL + "contacts?";

	/**
	 * @FIRSTTIMELOGIN {@link requires}<br>
	 */
	public static final String FIRSTTIMELOGIN = BASE_URL + "firsttime_login?";

	/**
	 * @FAMILY {@link requires}<br>
	 *         user_id<br>
	 */

	public static final String FAMILY = BASE_URL + "family?";
	/**
	 * @REPORT_TYPE_DROPDOWN {@link requires}<br>
	 */
	public static final String REPORT_TYPE_DROPDOWN = BASE_URL + "report_type_dropdown?";

	/**
	 * @REPORT_TYPE_FAMILY_DROPDOWN {@link requires}<br>
	 *                              user_id<br>
	 */
	public static final String REPORT_TYPE_FAMILY_DROPDOWN = BASE_URL + "report_type_family_dropdown?";

	/**
	 * @MYPROFILE {@link requires}<br>
	 *            user_id
	 */
	public static final String MY_PROFILE = BASE_URL + "my_profile?";
	/**
	 * @EDITPROFILE {@link requires}<br>
	 *              user_id<br>
	 *              profile_photo <br>
	 *              first_name <br>
	 *              last_name <br>
	 *              birthdate<br>
	 *              gender <br>
	 *              bloodgroup <br>
	 *              country_id<br>
	 *              address <br>
	 *              pin_code<br>
	 *              phone_no <br>
	 *              mobile_no email <br>
	 *              password<br>
	 *              weight<br>
	 */
	public static final String EDIT_PROFILE = BASE_URL + "edit_profile?";

	/**
	 * @MY_DOCUMENTS {@link requires}<br>
	 *               user_id
	 */
	public static final String MY_DOCUMENTS = BASE_URL + "my_documents?";

	/**
	 * @NOTIFICATIONS {@link requires}<br>
	 */
	public static final String NOTIFICATIONS = BASE_URL + "notifications?";

	/**
	 * @MY_TEST_REPORTS {@link requires}<br>
	 *                  user_id<br>
	 *                  persone<br>
	 *                  from_date<br>
	 *                  to_date<br>
	 *                  filter_report_type
	 */
	public static final String MY_TEST_REPORTS = BASE_URL + "my_test_reports?";

	/**
	 * @COMPLAINTS_LISTINGsss {@link requires}<br>
	 *                        user_id<br>
	 */
	public static final String COMPLAINTS_LISTING = BASE_URL + "complaints_listing?";

	/**
	 * @UPLOAD_REPORT {@link requires}<br>
	 *                user_id<br>
	 *                contact_id<br>
	 *                report_date<br>
	 *                report<br>
	 */

	public static final String SEARCH_DOCTOR = BASE_URL + "search_doctor?";

	/**
	 * @SEARCH_DOCTOR {@link requires}<br>
	 *                user_id<br>
	 *                name<br>
	 *                latitude<br>
	 *                longitude<br>
	 */
	public static final String UPLOAD_REPORT = BASE_URL + "upload_report?";

	/**
	 * @ADD_DOCUMENTS {@link requires}<br>
	 *                user_id<br>
	 *                document_file<br>
	 */
	public static final String ADD_DOCUMENTS = BASE_URL + "add_documents?";

	/**
	 * @DELETE_REPORT {@link requires}<br>
	 *                report_id<br>
	 */
	public static final String DELETE_REPORT = BASE_URL + "delete_report?";
	/**
	 * @FAMILY_PROFILE {@link requires}<br>
	 *                 user_family_id<br>
	 */
	public static final String FAMILY_PROFILE = BASE_URL + "view_family_member_profile?";

	/**
	 * @PARAMETER_DETAILS {@link requires}<br>
	 *                    my_parameter_id<br>
	 */
	public static final String PARAMETER_DETAILS = BASE_URL + "parameter_details?";

	/**
	 * @MMPSEND {@link requires}<br>
	 *          user_id<br>
	 */
	public static String MMP_SEND = BASE_URL + "sent_mmp?";

	/**
	 * @MMPRCV {@link requires}<br>
	 *         user_id<br>
	 */
	public static String MMP_RCV = BASE_URL + "received_mmp?";

	/**
	 * DELETE {@link requires}<br>
	 * user_id <br>
	 * password <br>
	 * */

	public static final String DELETE = BASE_URL + "delete_account?";

	/**
	 * SHARE_DETAILS {@link requires}<br>
	 * user_id<br>
	 * person<br>
	 * from_date<br>
	 * to_date<br>
	 * send_type<br>
	 * receiver_id<br>
	 */

	public static final String SHARE_DETAILS = BASE_URL + "mmp_share_details?";

	public static final String HELP = BASE_URL + "help?";

	/**
	 * FAV_PARAMERTS {@link requires}<br>
	 * user_id<br>
	 * person<br>
	 */
	public static final String FAV_PARAMETERS = BASE_URL + "favorite_parameters?";

	/**
	 * QUICK_PARAMETER {@link requires}<br>
	 * my_parameter_id<br>
	 * current_measurements<br>
	 */
	public static final String QUICK_PARAMETER = BASE_URL + "quick_parameter?";

	public static final String DELETE_PARAMETER = BASE_URL + "delete_parameter?";

	public static final String DELETE_MEDICINES = BASE_URL + "delete_medicines?";

	/**
	 * DELETE_COMPLAINTS {@link requires}<br>
	 * user_compaints_id<br>
	 */
	public static final String DELETE_COMPLAINTS = BASE_URL + "delete_complaints?";

	/**
	 * DELETE REPORT {@link requires}<br>
	 * report_id<br>
	 * 
	 */
	public static final String DELETE_TESTREPORT = BASE_URL + "delete_report?";

	/**
	 * DELETE DOCUMENT {@link requires}<br>
	 * my_document_id<br>
	 * 
	 */
	public static final String DELETE_DOCUMENT = BASE_URL + "delete_document?";
	/**
	 * @MedicineDEtails {@link requires}<br>
	 *                  medicine_id<br>
	 * 
	 */
	public static final String MEDICINE_DETAILS = BASE_URL + "view_medicine_details?";
	/**
	 * @ParameterDetails {@link requires}<br>
	 *                   my_parameter_id<br>
	 * 
	 */
	public static final String PARAMETER_dETAILS = BASE_URL + "parameter_details?";

	/**
	 * @ParameterDetails {@link requires}<br>
	 *                   my_parameter_id<br>
	 * 
	 */
	public static final String DOCTOR_INVITATION_SENT = BASE_URL + "doctor_invitation_sent?";
	public static final String DOCTOR_DEGREE_LIST = BASE_URL + "doctor_degree_listing?";
	/**
	 * @DOCTOR_DEGREE_LIST{@link requires}<br>
	 *                           user_id <br>
	 *
	 * */

	public static final String MESSAGE_LISTING = BASE_URL + "message_listing?";
	/**
	 * @DOCTOR_MESSAGE_LISTING {@link requires}<br>
	 *                         user_id<br>
	 *                         sender_id<br>
	 * 
	 * 
	 * */

	public static final String OFFLINE_CHAT = BASE_URL + "offline_chat?";

	/**
	 * @CLEAR_CHAT_HISTORY {@link requires}<br>
	 *                     user_id<br>
	 *                     other_id<br>
	 * 
	 * 
	 * */

	public static final String CLEAR_CHAT_HISTORY = BASE_URL + "clear_chat_history?";

	/**
	 * @OFFLINE_CHAT {@link requires}<br>
	 *               user_id<br>
	 *               sender_id<br>
	 *               sender_type<br>
	 * 
	 * 
	 * */

	public static final String DISCLAIMERDOCTOR = BASE_URL + "disclaimerdoctor?";

	public static final String BLOCK_UNBLOCK_USER = BASE_URL + "block_unblock_user?";

}
