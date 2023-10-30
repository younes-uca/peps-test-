import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown, DropdownChangeEvent} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import { parse } from 'date-fns';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';



import {OrderBoutiqueAdminService} from 'app/controller/service/admin/OrderBoutiqueAdminService.service';
import  {OrderBoutiqueDto}  from 'app/controller/model/OrderBoutique.model';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

import {OrderStatusDto} from 'app/controller/model/OrderStatus.model';
import {OrderStatusAdminService} from 'app/controller/service/admin/OrderStatusAdminService.service';
import {OrderLineDto} from 'app/controller/model/OrderLine.model';
import {OrderLineAdminService} from 'app/controller/service/admin/OrderLineAdminService.service';
import {ProductDto} from 'app/controller/model/Product.model';
import {ProductAdminService} from 'app/controller/service/admin/ProductAdminService.service';
import {OrderBoutiqueCriteria} from "app/controller/criteria/OrderBoutiqueCriteria.model";
import useEditHook from "app/component/zyhook/useEdit.hook";


type OrderBoutiqueEditAdminType = {
    visible: boolean,
    onClose: () => void,
    showToast: React.Ref<Toast>,
    selectedItem: OrderBoutiqueDto
    update: (item: OrderBoutiqueDto) => void,
    list: OrderBoutiqueDto[],
    service: OrderBoutiqueAdminService,
    t: TFunction
}
const Edit: React.FC<OrderBoutiqueEditAdminType> = ({visible, onClose, showToast, selectedItem, update, list, service, t}) => {


    const isFormValid = () => {
    let errorMessages = new Array<string>();
        if(item.reference == '')
            errorMessages.push("reference is required")
        return errorMessages.length == 0 ;
    }
    const emptyItem = new OrderBoutiqueDto();


    const {
        item,
        setItem,
        submitted,
        setSubmitted,
        activeIndex,
        setActiveIndex,
        activeTab,
        setActiveTab,
        onInputTextChange,
        onInputDateChange,
        onInputNumerChange,
        onMultiSelectChange,
        onBooleanInputChange,
        onDropdownChange,
        onTabChange,
        hideDialog,
        editItem,
        formateDate,
        parseToIsoFormat,
        adaptDate
        } = useEditHook<OrderBoutiqueDto, OrderBoutiqueCriteria>({list, selectedItem, onClose, update, showToast,service, t, isFormValid})

    const [products, setProducts] = useState<ProductDto[]>([]);
    const [orderStatuss, setOrderStatuss] = useState<OrderStatusDto[]>([]);

    const [orderLines, setOrderLines] = useState<OrderLineDto>(new OrderLineDto());

    const orderStatusAdminService = new OrderStatusAdminService();
    const orderLineAdminService = new OrderLineAdminService();
    const productAdminService = new ProductAdminService();
    useEffect(() => {
    orderStatusAdminService.getList().then(({data}) => setOrderStatuss(data)).catch(error => console.log(error));


    productAdminService.getList().then(({data}) => setProducts(data)).catch(error => console.log(error));

        }, []);






    const addOrderLines = () => {
        setSubmitted(true);
        if( item.orderLines == null )
        item.orderLines = new Array<OrderLineDto>();
        let _item = orderLines;
        if (!_item.id) {
            item.orderLines.push(_item);
            MessageService.showSuccess(showToast, 'OrderLines Created');
            setItem((prevState :any) => ({...prevState, orderLines: item.orderLines }));
        } else {
            const updatedItems = item.orderLines.map((item) => item.id === orderLines.id ? {...orderLines} : item);
            MessageService.showSuccess(showToast, 'OrderLines Updated');
            setItem((prevState :any) => ({ ...prevState, orderLines: updatedItems}));
        }
        setOrderLines(new OrderLineDto());
    };

    const deleteOrderLines = (rowData: any) => {
        const updatedItems = item.orderLines.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, orderLines: updatedItems }));
        setOrderLines(new OrderLineDto());
        MessageService.showSuccess(showToast, 'OrderBoutiqueItem Deleted');
    };

    const editOrderLines = (rowData: any) => {
        setActiveTab(0);
        setOrderLines(rowData);
    };

    const onInputNumerChangeOrderLines = (e: any, name: string) => {
        const val = e.value || 0;
        setOrderLines((prevOrderLines) => ({ ...prevOrderLines, [name]: val, }));
    };

    const onDropdownChangeOrderLines = (e: any, field: string) => {
        setOrderLines((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeOrderLines = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setOrderLines(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeOrderLines = (e: any, name: string) => {
        const val = e.value;
        setOrderLines((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeOrderLines = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setOrderLines({ ...orderLines, [name]:val})
    };

    const onInputTextChangeOrderLines = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setOrderLines({ ...orderLines, [name]:val})
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" onClick={editItem} /> </>
    );



    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={{'orderBoutique.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={{'orderBoutique.tabPan' | translate}}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="reference">{{'orderBoutique.reference' | translate}}</label>
                        <InputText id="reference" value={item ? item.reference : ''} onChange={(e) => onInputTextChange(e, 'reference')} required className={classNames({'p-invalid': submitted && !item.reference})} />
                        {submitted && !item.reference && <small className="p-invalid">Reference is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="orderDate">{{'orderBoutique.orderDate' | translate}}</label>
                        <Calendar id="orderDate" value={adaptDate(item?.orderDate)} onChange={(e) => onInputDateChange(e, 'orderDate')} dateFormat="dd/mm/yy" showIcon={true} />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="total">{{'orderBoutique.total' | translate}}</label>
                        <InputNumber id="total" value={item ? item.total : 0} onChange={(e) => onInputNumerChange(e, 'total')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="orderStatus">{{'orderBoutique.orderStatus' | translate}}</label>
                        <Dropdown  id="orderStatusDropdown"  value={item ? item.orderStatus : ''} options={orderStatuss} onChange={(e) => onDropdownChange(e, 'orderStatus')}   placeholder="Sélectionnez un orderStatus" filter filterPlaceholder="Rechercher un orderStatus" optionLabel="libelle" showClear />
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={{'orderBoutique.orderLines' | translate}}>
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="price">{{'orderLine.price' | translate}}</label>
                                <InputNumber id="price" value={orderLines.price}  onValueChange={(e) => onInputNumerChangeOrderLines(e, 'price')}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="quantity">{{'orderLine.quantity' | translate}}</label>
                                <InputNumber id="quantity" value={orderLines.quantity}  onValueChange={(e) => onInputNumerChangeOrderLines(e, 'quantity')}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="quantityReceived">{{'orderLine.quantityReceived' | translate}}</label>
                                <InputNumber id="quantityReceived" value={orderLines.quantityReceived}  onValueChange={(e) => onInputNumerChangeOrderLines(e, 'quantityReceived')}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="product">{{'orderLine.product' | translate}}</label>
                                <Dropdown id="productDropdown" value={orderLines.product} options={products} onChange={(e) => onDropdownChangeOrderLines(e, 'product')} placeholder="Sélectionnez un product" filter  filterPlaceholder="Rechercher un product"  optionLabel="libelle" showClear />
                            </div>

                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addOrderLines} />
                            </div>
                        </div>
                        <div className="p-col">
                        <div className="card">
                            <DataTable value={item.orderLines} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="price" header={{'orderLine.price' | translate}} ></Column>
                                <Column field="quantity" header={{'orderLine.quantity' | translate}} ></Column>
                                <Column field="quantityReceived" header={{'orderLine.quantityReceived' | translate}} ></Column>
                                <Column field="product.libelle" header={{'orderLine.product' | translate}}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteOrderLines(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editOrderLines(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                        </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


