/* -*- java -*-
# =========================================================================== #
#                                                                             #
#                         Copyright (C) KNAPP AG                              #
#                                                                             #
#       The copyright to the computer program(s) herein is the property       #
#       of Knapp.  The program(s) may be used   and/or copied only with       #
#       the  written permission of  Knapp  or in  accordance  with  the       #
#       terms and conditions stipulated in the agreement/contract under       #
#       which the program(s) have been supplied.                              #
#                                                                             #
# =========================================================================== #
*/

package com.knapp.codingcontest.solution;

import java.util.*;
import java.util.Deque;

import com.knapp.codingcontest.data.InputData;
import com.knapp.codingcontest.data.Institute;
import com.knapp.codingcontest.data.Order;
import com.knapp.codingcontest.data.Product;
import com.knapp.codingcontest.operations.CostFactors;
import com.knapp.codingcontest.operations.InfoSnapshot;
import com.knapp.codingcontest.operations.InfoSnapshot.OperationType;
import com.knapp.codingcontest.operations.Warehouse;
import com.knapp.codingcontest.operations.WorkStation;

/**
 * This is the code YOU have to provide
 */
public class Solution {
    public String getParticipantName() {
        // lines containing '@TODO' are removed before packaging contest-sandbox
        return "Maximilian Kniely"; // TODO: return your name
    }

    public Institute getParticipantInstitution() {
        // lines containing '@TODO' are removed before packaging contest-sandbox
        return Institute.HTL_Rennweg_Wien; // TODO: return the Id of your institute - please refer to the hand-out
    }

    // ----------------------------------------------------------------------------

    protected final Warehouse warehouse;
    protected final WorkStation workStation;
    protected final InputData input;

    // ----------------------------------------------------------------------------

    public Solution(final Warehouse warehouse, final InputData input) {
        this.warehouse = warehouse;
        workStation = warehouse.getWorkStation();
        this.input = input;
    }

    // ----------------------------------------------------------------------------

    /**
     * The main entry-point.
     */
    public void run() throws Exception {
        ArrayList<Order> orders = new ArrayList<>(input.getAllOrders());

        while(!orders.isEmpty()) {
            Order order = orders.iterator().next();
            workStation.startOrder(order);

            List<Product> products = new ArrayList<>(order.getOpenProducts());

            while (!products.isEmpty()){
                if (workStation.getAssignedProducts().contains(products.get(0))){
                    workStation.pickOrder(order, products.get(0));
                }else{
                    if (workStation.getAssignedProducts().size()< workStation.getProductSlots()){
                        workStation.assignProduct(products.get(0));
                    }
                    else{
                        ArrayList<Product> pps = new ArrayList<>(workStation.getAssignedProducts());
                        for (Product pp: pps){
                            while (order.getOpenProducts().contains(pp)){
                                workStation.pickOrder(order, pp);
                            }
                            workStation.removeProduct(pp);
                        }
                    }
                }
                products = new ArrayList<>(order.getOpenProducts());
            }
            orders.remove(0);
        }
    }

    // ----------------------------------------------------------------------------
    // ----------------------------------------------------------------------------

    /**
     * Just for documentation purposes.
     * <p>
     * Method may be removed without any side-effects
     * divided into these sections
     *
     * <li><em>input methods</em>
     *
     * <li><em>main interaction methods</em>
     * - these methods are the ones that make (explicit) changes to the warehouse
     *
     * <li><em>information</em>
     * - information you might need for your solution
     *
     * <li><em>additional information</em>
     * - various other infos: statistics, information about (current) costs, ...
     */
    @SuppressWarnings("unused")
    private void apis() throws Exception {
        // ----- input -----

        final Collection<Order> orders = input.getAllOrders();

        final Order order = orders.iterator().next();
        final Product product = order.getOpenProducts().get(0);

        final WorkStation workStation = warehouse.getWorkStation();

        // ----- main interaction methods -----

        workStation.startOrder(order);
        workStation.assignProduct(product);
        workStation.removeProduct(product);
        workStation.pickOrder(order, product);

        // ----- information -----

        final List<Product> aps = order.getAllProducts();
        final List<Product> ops = order.getOpenProducts();
        final boolean ofin = order.isFinished();

        final int wsos = workStation.getOrderSlots();
        final int wsps = workStation.getProductSlots();

        final Set<Order> waaos = workStation.getActiveOrders();
        final Set<Product> wsaps = workStation.getAssignedProducts();

        // ----- additional information -----

        final CostFactors costFactors = input.getCostFactors();
        final double cf_pa = costFactors.getProductAssignmentCost();
        final double cf_up = costFactors.getUnfinishedProductPenalty();

        final InfoSnapshot info = warehouse.getInfoSnapshot();

        final int up = info.getUnfinishedProductCount();
        final int oso = info.getOperationCount(OperationType.StartOrder);
        final int oap = info.getOperationCount(OperationType.AssignProduct);
        final int orp = info.getOperationCount(OperationType.RemoveProduct);
        final int opo = info.getOperationCount(OperationType.PickOrder);

        final double c_uo = info.getUnfinishedOrdersCost();
        final double c_pa = info.getProductAssignmentCost();
        final double c_t = info.getTotalCost();
    }

    // ----------------------------------------------------------------------------
}
