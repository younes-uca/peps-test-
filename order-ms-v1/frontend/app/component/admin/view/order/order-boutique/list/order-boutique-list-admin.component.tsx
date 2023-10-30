import {Button} from 'primereact/button';
import {Column} from 'primereact/column';


import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {FileUpload} from 'primereact/fileupload';
import {InputText} from 'primereact/inputtext';
import {Toast} from 'primereact/toast';
import {Toolbar} from 'primereact/toolbar';
import React, {useEffect, useRef, useState} from 'react';
import {Paginator, PaginatorPageChangeEvent} from 'primereact/paginator';
import {Card} from 'primereact/card';
import {Calendar} from 'primereact/calendar';
import {InputNumber} from 'primereact/inputnumber';
import {Dropdown} from 'primereact/dropdown';
import {format} from "date-fns";
import useListHook from "app/component/zyhook/useListhook";
import {MessageService} from 'app/zynerator/service/MessageService';


import {OrderBoutiqueAdminService} from 'app/controller/service/admin/OrderBoutiqueAdminService.service';
import {OrderBoutiqueDto}  from 'app/controller/model/OrderBoutique.model';
import {OrderBoutiqueCriteria} from 'app/controller/criteria/OrderBoutiqueCriteria.model';

import {OrderStatusDto} from 'app/controller/model/OrderStatus.model';
import {OrderStatusAdminService} from 'app/controller/service/admin/OrderStatusAdminService.service';

import { useTranslation } from 'react-i18next';

import Edit from '../edit/order-boutique-edit-admin.component';
import Create from '../create/order-boutique-create-admin.component';
import View from '../view/order-boutique-view-admin.component';


const List = () => {

    const { t } = useTranslation();

    const emptyItem = new OrderBoutiqueDto();
    const emptyCriteria = new OrderBoutiqueCriteria();
    const service = new OrderBoutiqueAdminService();


    const {
        items,
        showSearch,
        deleteItemDialog,
        item,
        selectedItems,
        setSelectedItems,
        hideDeleteItemDialog,
        globalFilter,
        setGlobalFilter,
        showCreateDialog,
        setShowCreateDialog,
        showEditDialog,
        setShowEditDialog,
        showViewDialog,
        setShowViewDialog,
        selectedItem,
        setSelectedItem,
        rows,
        totalRecords,
        criteria,
        setCriteria,
        first,
        fetchItems,
        toast,
        dt,
        findByCriteriaShow,
        handleCancelClick,
        confirmDeleteSelected,
        exportCSV,
        deleteItem,
        deleteItemDialogFooter,
        leftToolbarTemplate,
        rightToolbarTemplate,
        actionBodyTemplate,
        CustomBooleanCell,
        handleValidateClick,
        onPage,
        showCreateModal,
        showEditModal,
        showViewModal,
        add,
        update,
        confirmDeleteItem,
        statusBodyTemplate,
        formateDate,
        deleteSelectedItems,
        deleteItemsDialog,
        deleteItemsDialogFooter,
        hideDeleteItemsDialog
    } = useListHook<OrderBoutiqueDto, OrderBoutiqueCriteria>({ emptyItem, emptyCriteria,service, t})



    const [orderStatuss, setOrderStatuss] = useState<OrderStatusDto[]>([]);

    const orderStatusAdminService = new OrderStatusAdminService();

    useEffect(() => {

        orderStatusAdminService.getList().then(({data}) => setOrderStatuss(data)).catch(error => console.log(error));
        fetchItems(criteria);
    }, []);



    const header = (
    <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">{t("orderBoutique.header")}</h5>
        <span className="block mt-2 md:mt-0 p-input-icon-left"><i className="pi pi-search"/>
            <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)}
                       placeholder={t("search")}/> </span>
    </div>
    );
    return (
    <div className="grid crud-demo">
        <div className="col-12">
            <div className="card">
                <Toast ref={toast} />
                <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>
                {findByCriteriaShow && (
                <Card title={t("search")} className="mb-5">
                        <div className="grid">
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="1">{{'orderBoutique.reference' | translate}}</label>
                                <InputText id="1" value={criteria.reference} onChange={(e) => setCriteria({ ...criteria, reference: e.target.value })} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="2-1">{{'orderBoutique.orderDateMin' | translate}}</label>
                                <Calendar id="2-1" value={criteria.orderDateFrom} onChange={(e) => setCriteria({ ...criteria, orderDateFrom: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="2-2">{{'orderBoutique.orderDateMax' | translate}}</label>
                                <Calendar id="2-2" value={criteria.orderDateTo} onChange={(e) => setCriteria({ ...criteria, orderDateTo: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="3-1">{{'orderBoutique.totalMin' | translate}}</label>
                                <InputNumber id="3-1" value={criteria.totalMin} onChange={(e) => setCriteria({ ...criteria, totalMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="3-2">{{'orderBoutique.totalMax' | translate}}  </label>
                                <InputNumber id="3-2" value={criteria.totalMax} onChange={(e) => setCriteria({ ...criteria, totalMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="5">{{'orderBoutique.orderStatusPlaceHolder' | translate}}</label>
                                <Dropdown id="5" value={criteria.orderStatus} options={orderStatuss} onChange={(e) => setCriteria({ ...criteria, orderStatus: e.target.value })} optionLabel="libelle" filter showClear/>
                            </div>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label={t("validate")} icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label={t("cancel")} className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as OrderBoutiqueDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="reference" header={{'orderBoutique.reference' | translate}} sortable></Column>
                    
                    
                    <Column field="orderDate" header={{'orderBoutique.orderDate' | translate}} sortable body={formateDate("orderDate")}></Column>
                    
                    
                    <Column field="total" header={{'orderBoutique.total' | translate}} sortable></Column>
                    
                    
                    <Column field="orderStatus.libelle" header={{'orderBoutique.orderStatus' | translate}} sortable ></Column>
                    
                    <Column header={t("actions")} body={actionBodyTemplate}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                {showCreateDialog && <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items} service={service} t={t} />}

                {showEditDialog && <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(emptyItem); }} showToast={toast} selectedItem={selectedItem} update={update} list={items} service={service}   t={t} />}

                {showViewDialog && <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(emptyItem); }} selectedItem={selectedItem}   t={t} />}
                <Dialog visible={deleteItemDialog} style={{width: '450px'}} header={t("confirm")} modal footer={deleteItemDialogFooter} onHide={hideDeleteItemDialog}>
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}}/>
                    {item && (<span>{t("orderBoutique.deleteOrderBoutiqueConfirmationMessage")} <b>{item.reference}</b>?</span>)}
                    </div>
                </Dialog>

            <Dialog visible={deleteItemsDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                    {item && <span>{t("orderBoutique.deleteOrderBoutiquesConfirmationMessage")}</span>}
                </div>
            </Dialog>

            </div>
        </div>
    </div>
);
};
export default List;

