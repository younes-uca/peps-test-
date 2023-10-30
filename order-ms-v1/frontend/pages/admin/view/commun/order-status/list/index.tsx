import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import OrderStatussList from 'app/component/admin/view/commun/order-status/list/order-status-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const OrderStatuss: NextPageWithLayout = () => {
    return <OrderStatussList />
}

OrderStatuss.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default OrderStatuss;
