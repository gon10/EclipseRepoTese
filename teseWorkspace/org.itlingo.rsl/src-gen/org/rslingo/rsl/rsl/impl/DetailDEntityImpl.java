/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.rsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.rslingo.rsl.rsl.DataEntity;
import org.rslingo.rsl.rsl.DetailDEntity;
import org.rslingo.rsl.rsl.RefDEntity;
import org.rslingo.rsl.rsl.RslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Detail DEntity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DetailDEntityImpl#getDEntityDetail <em>DEntity Detail</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DetailDEntityImpl#getRefDEntity <em>Ref DEntity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DetailDEntityImpl extends MinimalEObjectImpl.Container implements DetailDEntity
{
  /**
   * The cached value of the '{@link #getDEntityDetail() <em>DEntity Detail</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDEntityDetail()
   * @generated
   * @ordered
   */
  protected DataEntity dEntityDetail;

  /**
   * The cached value of the '{@link #getRefDEntity() <em>Ref DEntity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefDEntity()
   * @generated
   * @ordered
   */
  protected RefDEntity refDEntity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DetailDEntityImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RslPackage.Literals.DETAIL_DENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataEntity getDEntityDetail()
  {
    if (dEntityDetail != null && dEntityDetail.eIsProxy())
    {
      InternalEObject oldDEntityDetail = (InternalEObject)dEntityDetail;
      dEntityDetail = (DataEntity)eResolveProxy(oldDEntityDetail);
      if (dEntityDetail != oldDEntityDetail)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RslPackage.DETAIL_DENTITY__DENTITY_DETAIL, oldDEntityDetail, dEntityDetail));
      }
    }
    return dEntityDetail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataEntity basicGetDEntityDetail()
  {
    return dEntityDetail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDEntityDetail(DataEntity newDEntityDetail)
  {
    DataEntity oldDEntityDetail = dEntityDetail;
    dEntityDetail = newDEntityDetail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DETAIL_DENTITY__DENTITY_DETAIL, oldDEntityDetail, dEntityDetail));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefDEntity getRefDEntity()
  {
    return refDEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRefDEntity(RefDEntity newRefDEntity, NotificationChain msgs)
  {
    RefDEntity oldRefDEntity = refDEntity;
    refDEntity = newRefDEntity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RslPackage.DETAIL_DENTITY__REF_DENTITY, oldRefDEntity, newRefDEntity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefDEntity(RefDEntity newRefDEntity)
  {
    if (newRefDEntity != refDEntity)
    {
      NotificationChain msgs = null;
      if (refDEntity != null)
        msgs = ((InternalEObject)refDEntity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RslPackage.DETAIL_DENTITY__REF_DENTITY, null, msgs);
      if (newRefDEntity != null)
        msgs = ((InternalEObject)newRefDEntity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RslPackage.DETAIL_DENTITY__REF_DENTITY, null, msgs);
      msgs = basicSetRefDEntity(newRefDEntity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DETAIL_DENTITY__REF_DENTITY, newRefDEntity, newRefDEntity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RslPackage.DETAIL_DENTITY__REF_DENTITY:
        return basicSetRefDEntity(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RslPackage.DETAIL_DENTITY__DENTITY_DETAIL:
        if (resolve) return getDEntityDetail();
        return basicGetDEntityDetail();
      case RslPackage.DETAIL_DENTITY__REF_DENTITY:
        return getRefDEntity();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RslPackage.DETAIL_DENTITY__DENTITY_DETAIL:
        setDEntityDetail((DataEntity)newValue);
        return;
      case RslPackage.DETAIL_DENTITY__REF_DENTITY:
        setRefDEntity((RefDEntity)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RslPackage.DETAIL_DENTITY__DENTITY_DETAIL:
        setDEntityDetail((DataEntity)null);
        return;
      case RslPackage.DETAIL_DENTITY__REF_DENTITY:
        setRefDEntity((RefDEntity)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RslPackage.DETAIL_DENTITY__DENTITY_DETAIL:
        return dEntityDetail != null;
      case RslPackage.DETAIL_DENTITY__REF_DENTITY:
        return refDEntity != null;
    }
    return super.eIsSet(featureID);
  }

} //DetailDEntityImpl
