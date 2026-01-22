<?php

use app\models\Produkte;
use yii\helpers\Html;
use yii\helpers\Url;
use yii\grid\ActionColumn;
use yii\grid\GridView;
use yii\widgets\Pjax;
use yii\bootstrap5\ActiveForm;
/** @var yii\web\View $this */
/** @var app\models\ProdukteSearch $searchmodel */
/** @var yii\data\ActiveDataProvider $dataProvider */
/** @var app\models\Produkte $produkte array[] */
/** @var app\models\Produkte $produkt array[] */

$this->title = Yii::t('app', 'Produktes');
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produkte-index">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a(Yii::t('app', 'Create Produkte'), ['create'], ['class' => 'btn btn-success']) ?>
    </p>
    <?php $form = ActiveForm::begin(); ?>
    <?= $form->field($searchmodel, 'text')->textInput() ?>
    <?= Html::submitButton(Yii::t('app', 'search'), ['class' => 'btn btn-success']) ?>
    <?php \yii\bootstrap5\ActiveForm::end() ?>

    <br>
    <div class="row g-3">
    <?php foreach ($produkte as $produkt): ?>
        <div class="col-12 col-sm-6 col-lg-3">
            <div class="card h-100">
                <div class="card-header fs-5 fw-semibold">
                    <b>ProduktID:</b>
                    <?= $produkt->ProduktID?>
                </div>
                <div class="card-body">
                    <b>Produkt:</b><br>
                    <?= $produkt->Produktname?>
                </div>
                <div class="card-footer">
                    <b>Lieferant:</b><br>
                    <?= $produkt->lieferanten->Lieferantenname?>
                </div>
                <div class="card-footer">
                    <?= \yii\bootstrap5\Html::a($produkt->iconUpdate(), Url::to(['produkte/update', 'ProduktID' => $produkt->ProduktID]), ['class' => 'btn btn-primary']) ?>
                    <?= \yii\bootstrap5\Html::a($produkt->iconDelete(), Url::to(['produkte/delete', 'ProduktID' => $produkt->ProduktID]), ['class' => 'btn btn-danger', 'data-method' => 'post', 'data-confirm' => 'Do you want to delete the item surely???']) ?>
                </div>
            </div>
        </div>
    <?php endforeach;?>
    </div>
</div>
