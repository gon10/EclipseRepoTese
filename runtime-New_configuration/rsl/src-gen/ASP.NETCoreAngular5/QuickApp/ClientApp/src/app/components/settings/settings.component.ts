// ====================================================
// More Templates: https://www.ebenmonney.com/templates
// Email: support@ebenmonney.com
// ====================================================

import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


import { fadeInOut } from '../../services/animations';
import { BootstrapTabDirective } from "../../directives/bootstrap-tab.directive";
import { AccountService } from "../../services/account.service";
import { Permission } from '../../models/permission.model';


@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css'],
  animations: [fadeInOut]
})
export class SettingsComponent implements OnInit, OnDestroy {

  isProfileActivated = true;
  isPreferencesActivated = false;
  isUsersActivated = false;
  isRolesActivated = false;
  isE_VATActivated = false;
  isE_ProductActivated = false;
  isE_CustomerActivated = false;
  isE_CustomerAdressActivated = false;
  isE_CustomerVIPActivated = false;
  isE_InvoiceActivated = false;
  isE_InvoiceLineActivated = false;

  fragmentSubscription: any;

  readonly profileTab = "profile";
  readonly preferencesTab = "preferences";
  readonly usersTab = "users";
  readonly rolesTab = "roles";
  readonly E_VATTab = 'E_VAT';
  readonly E_ProductTab = 'E_Product';
  readonly E_CustomerTab = 'E_Customer';
  readonly E_CustomerAdressTab = 'E_CustomerAdress';
  readonly E_CustomerVIPTab = 'E_CustomerVIP';
  readonly E_InvoiceTab = 'E_Invoice';
  readonly E_InvoiceLineTab = 'E_InvoiceLine';

  @ViewChild("tab")
  tab: BootstrapTabDirective;


  constructor(private route: ActivatedRoute, private accountService: AccountService) {
  }


  ngOnInit() {
    this.fragmentSubscription = this.route.fragment.subscribe(anchor => this.showContent(anchor));
  }


  ngOnDestroy() {
    this.fragmentSubscription.unsubscribe();
  }

  showContent(anchor: string) {
    if ((this.isFragmentEquals(anchor, this.usersTab) && !this.canViewUsers) ||
      (this.isFragmentEquals(anchor, this.rolesTab) && !this.canViewRoles)
      || (this.isFragmentEquals(anchor, this.E_VATTab) && !this.canViewE_VAT)
      || (this.isFragmentEquals(anchor, this.E_ProductTab) && !this.canViewE_Product)
      || (this.isFragmentEquals(anchor, this.E_CustomerTab) && !this.canViewE_Customer)
      || (this.isFragmentEquals(anchor, this.E_CustomerAdressTab) && !this.canViewE_CustomerAdress)
      || (this.isFragmentEquals(anchor, this.E_CustomerVIPTab) && !this.canViewE_CustomerVIP)
      || (this.isFragmentEquals(anchor, this.E_InvoiceTab) && !this.canViewE_Invoice)
      || (this.isFragmentEquals(anchor, this.E_InvoiceLineTab) && !this.canViewE_InvoiceLine)
	) {
      return;
	}
    this.tab.show(`#${anchor || this.profileTab}Tab`);
  }


  isFragmentEquals(fragment1: string, fragment2: string) {

    if (fragment1 == null)
      fragment1 = "";

    if (fragment2 == null)
      fragment2 = "";

    return fragment1.toLowerCase() == fragment2.toLowerCase();
  }


  onShowTab(event) {
    let activeTab = event.target.hash.split("#", 2).pop();

    this.isProfileActivated = activeTab == this.profileTab;
    this.isPreferencesActivated = activeTab == this.preferencesTab;
    this.isUsersActivated = activeTab == this.usersTab;
    this.isRolesActivated = activeTab == this.rolesTab;
	this.isE_VATActivated = activeTab == this.E_VATTab;
	this.isE_ProductActivated = activeTab == this.E_ProductTab;
	this.isE_CustomerActivated = activeTab == this.E_CustomerTab;
	this.isE_CustomerAdressActivated = activeTab == this.E_CustomerAdressTab;
	this.isE_CustomerVIPActivated = activeTab == this.E_CustomerVIPTab;
	this.isE_InvoiceActivated = activeTab == this.E_InvoiceTab;
	this.isE_InvoiceLineActivated = activeTab == this.E_InvoiceLineTab;
  }


  get canViewUsers() {
    return this.accountService.userHasPermission(Permission.viewUsersPermission);
  }

  get canViewRoles() {
    return this.accountService.userHasPermission(Permission.viewRolesPermission);
  }
  get canViewE_VAT() {
  		    return true;
  		  }
  get canViewE_Product() {
  		    return true;
  		  }
  get canViewE_Customer() {
  		    return true;
  		  }
  get canViewE_CustomerAdress() {
  		    return true;
  		  }
  get canViewE_CustomerVIP() {
  		    return true;
  		  }
  get canViewE_Invoice() {
  		    return true;
  		  }
  get canViewE_InvoiceLine() {
  		    return true;
  		  }
}
