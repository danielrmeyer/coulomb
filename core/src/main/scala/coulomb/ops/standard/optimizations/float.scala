/*
 * Copyright 2022 Erik Erlandson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package coulomb.ops.standard.optimizations

import scala.util.NotGiven
import scala.Conversion

import coulomb.{`*`, `/`, `^`}
import coulomb.{Quantity, withUnit}
import coulomb.ops.*

import coulomb.conversion.coefficients.*

object float:
    inline given ctx_quantity_neg_Float[U]: Neg[Float, U] =
        new Neg[Float, U]:
            def apply(q: Quantity[Float, U]): Quantity[Float, U] = (-(q.value)).withUnit[U]

    transparent inline given ctx_add_Float_1U[U]: Add[Float, U, Float, U] =
        new Add[Float, U, Float, U]:
            type VO = Float
            type UO = U
            def apply(ql: Quantity[Float, U], qr: Quantity[Float, U]): Quantity[Float, U] =
                (ql.value + qr.value).withUnit[U]

    transparent inline given ctx_add_Float_2U[UL, UR](using
        Conversion[Quantity[Float, UR], Quantity[Float, UL]]
            ): Add[Float, UL, Float, UR] =
        val c = coefficientFloat[UR, UL]
        new Add[Float, UL, Float, UR]:
            type VO = Float
            type UO = UL
            def apply(ql: Quantity[Float, UL], qr: Quantity[Float, UR]): Quantity[Float, UL] =
                (ql.value + (c * qr.value)).withUnit[UL]

    transparent inline given ctx_sub_Float_1U[U]: Sub[Float, U, Float, U] =
        new Sub[Float, U, Float, U]:
            type VO = Float
            type UO = U
            def apply(ql: Quantity[Float, U], qr: Quantity[Float, U]): Quantity[Float, U] =
                (ql.value - qr.value).withUnit[U]

    transparent inline given ctx_sub_Float_2U[UL, UR](using
        Conversion[Quantity[Float, UR], Quantity[Float, UL]]
            ): Sub[Float, UL, Float, UR] =
        val c = coefficientFloat[UR, UL]
        new Sub[Float, UL, Float, UR]:
            type VO = Float
            type UO = UL
            def apply(ql: Quantity[Float, UL], qr: Quantity[Float, UR]): Quantity[Float, UL] =
                (ql.value - (c * qr.value)).withUnit[UL]

    transparent inline given ctx_mul_Float_2U[UL, UR](using su: SimplifiedUnit[UL * UR]):
            Mul[Float, UL, Float, UR] =
        new Mul[Float, UL, Float, UR]:
            type VO = Float
            type UO = su.UO
            def apply(ql: Quantity[Float, UL], qr: Quantity[Float, UR]): Quantity[Float, UO] =
                (ql.value * qr.value).withUnit[UO]

    transparent inline given ctx_div_Float_2U[UL, UR](using su: SimplifiedUnit[UL / UR]):
            Div[Float, UL, Float, UR] =
        new Div[Float, UL, Float, UR]:
            type VO = Float
            type UO = su.UO
            def apply(ql: Quantity[Float, UL], qr: Quantity[Float, UR]): Quantity[Float, UO] =
                (ql.value / qr.value).withUnit[UO]