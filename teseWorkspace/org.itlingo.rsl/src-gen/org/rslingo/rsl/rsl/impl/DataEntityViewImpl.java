/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.rsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.rslingo.rsl.rsl.DataEntityView;
import org.rslingo.rsl.rsl.DataEntityViewType;
import org.rslingo.rsl.rsl.DetailDEntity;
import org.rslingo.rsl.rsl.MasterDEntity;
import org.rslingo.rsl.rsl.ReferenceDEntity;
import org.rslingo.rsl.rsl.RslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Entity View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getNameAlias <em>Name Alias</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getMaster <em>Master</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.impl.DataEntityViewImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataEntityViewImpl extends MinimalEObjectImpl.Container implements DataEntityView
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final DataEntityViewType TYPE_EDEFAULT = DataEntityViewType.VERY_SIMPLE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected DataEntityViewType type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getNameAlias() <em>Name Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameAlias()
   * @generated
   * @ordered
   */
  protected static final String NAME_ALIAS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNameAlias() <em>Name Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameAlias()
   * @generated
   * @ordered
   */
  protected String nameAlias = NAME_ALIAS_EDEFAULT;

  /**
   * The cached value of the '{@link #getMaster() <em>Master</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaster()
   * @generated
   * @ordered
   */
  protected MasterDEntity master;

  /**
   * The cached value of the '{@link #getDetails() <em>Details</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetails()
   * @generated
   * @ordered
   */
  protected EList<DetailDEntity> details;

  /**
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected EList<ReferenceDEntity> references;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataEntityViewImpl()
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
    return RslPackage.Literals.DATA_ENTITY_VIEW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataEntityViewType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(DataEntityViewType newType)
  {
    DataEntityViewType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNameAlias()
  {
    return nameAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameAlias(String newNameAlias)
  {
    String oldNameAlias = nameAlias;
    nameAlias = newNameAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__NAME_ALIAS, oldNameAlias, nameAlias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MasterDEntity getMaster()
  {
    return master;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMaster(MasterDEntity newMaster, NotificationChain msgs)
  {
    MasterDEntity oldMaster = master;
    master = newMaster;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__MASTER, oldMaster, newMaster);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaster(MasterDEntity newMaster)
  {
    if (newMaster != master)
    {
      NotificationChain msgs = null;
      if (master != null)
        msgs = ((InternalEObject)master).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RslPackage.DATA_ENTITY_VIEW__MASTER, null, msgs);
      if (newMaster != null)
        msgs = ((InternalEObject)newMaster).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RslPackage.DATA_ENTITY_VIEW__MASTER, null, msgs);
      msgs = basicSetMaster(newMaster, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__MASTER, newMaster, newMaster));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DetailDEntity> getDetails()
  {
    if (details == null)
    {
      details = new EObjectContainmentEList<DetailDEntity>(DetailDEntity.class, this, RslPackage.DATA_ENTITY_VIEW__DETAILS);
    }
    return details;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReferenceDEntity> getReferences()
  {
    if (references == null)
    {
      references = new EObjectContainmentEList<ReferenceDEntity>(ReferenceDEntity.class, this, RslPackage.DATA_ENTITY_VIEW__REFERENCES);
    }
    return references;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RslPackage.DATA_ENTITY_VIEW__DESCRIPTION, oldDescription, description));
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
      case RslPackage.DATA_ENTITY_VIEW__MASTER:
        return basicSetMaster(null, msgs);
      case RslPackage.DATA_ENTITY_VIEW__DETAILS:
        return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
      case RslPackage.DATA_ENTITY_VIEW__REFERENCES:
        return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
      case RslPackage.DATA_ENTITY_VIEW__NAME:
        return getName();
      case RslPackage.DATA_ENTITY_VIEW__TYPE:
        return getType();
      case RslPackage.DATA_ENTITY_VIEW__NAME_ALIAS:
        return getNameAlias();
      case RslPackage.DATA_ENTITY_VIEW__MASTER:
        return getMaster();
      case RslPackage.DATA_ENTITY_VIEW__DETAILS:
        return getDetails();
      case RslPackage.DATA_ENTITY_VIEW__REFERENCES:
        return getReferences();
      case RslPackage.DATA_ENTITY_VIEW__DESCRIPTION:
        return getDescription();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RslPackage.DATA_ENTITY_VIEW__NAME:
        setName((String)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__TYPE:
        setType((DataEntityViewType)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__NAME_ALIAS:
        setNameAlias((String)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__MASTER:
        setMaster((MasterDEntity)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__DETAILS:
        getDetails().clear();
        getDetails().addAll((Collection<? extends DetailDEntity>)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__REFERENCES:
        getReferences().clear();
        getReferences().addAll((Collection<? extends ReferenceDEntity>)newValue);
        return;
      case RslPackage.DATA_ENTITY_VIEW__DESCRIPTION:
        setDescription((String)newValue);
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
      case RslPackage.DATA_ENTITY_VIEW__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RslPackage.DATA_ENTITY_VIEW__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case RslPackage.DATA_ENTITY_VIEW__NAME_ALIAS:
        setNameAlias(NAME_ALIAS_EDEFAULT);
        return;
      case RslPackage.DATA_ENTITY_VIEW__MASTER:
        setMaster((MasterDEntity)null);
        return;
      case RslPackage.DATA_ENTITY_VIEW__DETAILS:
        getDetails().clear();
        return;
      case RslPackage.DATA_ENTITY_VIEW__REFERENCES:
        getReferences().clear();
        return;
      case RslPackage.DATA_ENTITY_VIEW__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
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
      case RslPackage.DATA_ENTITY_VIEW__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RslPackage.DATA_ENTITY_VIEW__TYPE:
        return type != TYPE_EDEFAULT;
      case RslPackage.DATA_ENTITY_VIEW__NAME_ALIAS:
        return NAME_ALIAS_EDEFAULT == null ? nameAlias != null : !NAME_ALIAS_EDEFAULT.equals(nameAlias);
      case RslPackage.DATA_ENTITY_VIEW__MASTER:
        return master != null;
      case RslPackage.DATA_ENTITY_VIEW__DETAILS:
        return details != null && !details.isEmpty();
      case RslPackage.DATA_ENTITY_VIEW__REFERENCES:
        return references != null && !references.isEmpty();
      case RslPackage.DATA_ENTITY_VIEW__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", type: ");
    result.append(type);
    result.append(", nameAlias: ");
    result.append(nameAlias);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //DataEntityViewImpl