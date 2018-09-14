// ====================================================
// More Templates: https://www.ebenmonney.com/templates
// Email: support@ebenmonney.com
// ====================================================

import { Component, OnInit, AfterViewInit, TemplateRef, ViewChild, Input } from '@angular/core';
import { ModalDirective } from 'ngx-bootstrap/modal';

import { AlertService, DialogType, MessageSeverity } from '../../services/alert.service';
import { AppTranslationService } from "../../services/app-translation.service";
import { AccountService } from "../../services/account.service";
import { Utilities } from "../../services/utilities";
import { User } from '../../models/user.model';
import { Role } from '../../models/role.model';
import { Permission } from '../../models/permission.model';
import { UserEdit } from '../../models/user-edit.model';
import { UserInfoComponent } from "./user-info.component";


@Component({
    selector: 'e-invoiceline-management',
    templateUrl: './e-invoiceline-management.component.html',
    styleUrls: ['./e-invoiceline-management.component.css']
})
export class EInvoiceLineManagementComponent implements OnInit{
    columns: any[] = [];
    rows: any[] = [];

    loadingIndicator: boolean;

    

    constructor(private alertService: AlertService, private translationService: AppTranslationService, private accountService: AccountService) {
    }


    ngOnInit() {

        let gT = (key: string) => this.translationService.getTranslation(key);

        this.columns = [
        	{ prop: "ID", name: 'ID'},		        	
        	{ prop: "invoiceID", name: 'invoiceID'},		        	
        	{ prop: "productID", name: 'productID'},		        	
        	{ prop: "valueWithoutVAT", name: 'valueWithoutVAT'},		        	
        	{ prop: "valueWithVAT", name: 'valueWithVAT'},		        	
        	{ prop: 'Description', name: 'Description'}
      ];

    }
}