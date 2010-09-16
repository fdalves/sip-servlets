package net.java.slee.resource.diameter.sh.server;

import java.io.IOException;

import net.java.slee.resource.diameter.base.DiameterActivity;
import net.java.slee.resource.diameter.sh.events.ProfileUpdateAnswer;
import net.java.slee.resource.diameter.sh.events.PushNotificationRequest;
import net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer;
import net.java.slee.resource.diameter.sh.events.UserDataAnswer;

/**
 * Activity used by a Diameter Sh Server for Notifications.
 * 
 * The following message can be fired as an event:
 * <UL>
 * <LI>PushNotificationAnswer
 * </UL>
 * <p/>
 * The following request can be sent:
 * <UL>
 * <LI>PushNotificationRequest
 * </UL>
 * 
 */
public interface ShServerSubscriptionActivity extends DiameterActivity {

  /**
   * Sends a push notification request asynchronously.
   * 
   * @param message
   *            message to send
   * @throws IOException
   *             if there is an error sending the message
   */
  void sendPushNotificationRequest(PushNotificationRequest message) throws IOException;

  /**
   * Create an empty PushNotificationRequest that will need to have AVPs set
   * on it before being sent. It has only minimal set of avps set.
   * 
   * @return a SubscribeNotificationsAnswer object that can be sent using
   *         {@link ShServerActivity#sendSubscribeNotificationsAnswer(net.java.slee.resource.diameter.sh.types.SubscribeNotificationsAnswer)}
   */
  PushNotificationRequest createPushNotificationRequest();

  /**
   * Create a SubscribeNotificationsAnswer containing a Result-Code or
   * Experimental-Result AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a SubscribeNotificationsAnswer object that can be sent using
   *         {@link ShServerActivity#sendSubscribeNotificationsAnswer(net.java.slee.resource.diameter.sh.types.SubscribeNotificationsAnswer)}
   */
  SubscribeNotificationsAnswer createSubscribeNotificationsAnswer(long resultCode, boolean isExperimentalResult);

  /**
   * Create a ProfileUpdateAnswer containing a Result-Code or
   * Experimental-Result AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a ProfileUpdateAnswer object that can be sent using
   *         {@link ShServerActivity#sendProfileUpdateAnswer(net.java.slee.resource.diameter.sh.types.ProfileUpdateAnswer)}
   */
  ProfileUpdateAnswer createProfileUpdateAnswer(long resultCode, boolean isExperimentalResult);

  /**
   * Create an empty ProfileUpdateAnswer that will need to have AVPs set on it
   * before being sent.
   * 
   * @return a ProfileUpdateAnswer object that can be sent using
   *         {@link ShServerActivity#sendProfileUpdateAnswer(net.java.slee.resource.diameter.sh.types.ProfileUpdateAnswer)}
   */
  ProfileUpdateAnswer createProfileUpdateAnswer();

  /**
   * Create a UserDataAnswer using the given parameter to populate the
   * User-Data AVP. The Result-Code AVP is automatically set to
   * {@link org.mobicents.slee.resource.diameter.base.DiameterResultCode#DIAMETER_SUCCESS}
   * .
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer(byte[] userData);

  /**
   * Create a UserDataAnswer containing a Result-Code or Experimental-Result
   * AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer(long resultCode, boolean isExperimentalResult);

  /**
   * Create an empty UserDataAnswer that will need to have AVPs set on it
   * before being sent.
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer();

  /**
   * Create an empty SubscribeNotificationsAnswer that will need to have AVPs
   * set on it before being sent.
   * 
   * @return a SubscribeNotificationsAnswer object that can be sent using
   *         {@link ShServerActivity#sendSubscribeNotificationsAnswer(net.java.slee.resource.diameter.sh.types.SubscribeNotificationsAnswer)}
   */
  SubscribeNotificationsAnswer createSubscribeNotificationsAnswer();

  /**
   * Send the SubscribeNotificationsAnswer to the peer that sent the
   * SubscribeNotificationsRequest.
   */
  void sendSubscribeNotificationsAnswer(SubscribeNotificationsAnswer message) throws IOException;

  /**
   * Send the UserDataAnswer to the peer that sent the UserDataRequest.
   */
  void sendUserDataAnswer(UserDataAnswer message) throws IOException;

  /**
   * Send the ProfileUpdateAnswer to the peer that sent the ProfileUpdateRequest.
   */
  void sendProfileUpdateAnswer(ProfileUpdateAnswer message) throws IOException;

}