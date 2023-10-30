/* eslint-disable @next/next/no-img-element */

import AppMenuitem from '/layout/AppMenuitem';
import {MenuProvider} from '/layout/context/menucontext';
import {AppMenuItem} from '/types/types';
import {AuthService} from 'app/zynerator/security/Auth.service';
import React, {useEffect, useState} from 'react';


const AppMenu = () => {

    const [model,setModel] = useState<AppMenuItem[]>([] as AppMenuItem[]);
    const authService = new AuthService();
        const modelAdmin: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
                {
                    label: 'Order Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste order boutique',
                     to: '/admin/view/order/order-boutique/list'
                      },
                    ]
                    },
                {
                    label: 'Product Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste product',
                     to: '/admin/view/catalog/product/list'
                      },
                      {
                      label: 'Liste product category',
                     to: '/admin/view/catalog/product-category/list'
                      },
                    ]
                    },
                {
                    label: 'Commun Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste order status',
                     to: '/admin/view/commun/order-status/list'
                      },
                    ]
                    },
            ]
        },

    ];

    useEffect(()=>{
        const roleConnectedUser = authService.getRoleConnectedUser();
        if(roleConnectedUser === 'ROLE_ADMIN'){
            setModel(modelAdmin)
        }
    },[])

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label}/> :
                        <li className="menu-separator"></li>;
                })}


            </ul>
        </MenuProvider>
    );
};


export default AppMenu;
