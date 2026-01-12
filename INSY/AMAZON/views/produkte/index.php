<?php

use app\models\Produkte;
use yii\helpers\Html;
use yii\helpers\Url;
use yii\grid\ActionColumn;
use yii\grid\GridView;
use yii\widgets\Pjax;
/** @var yii\web\View $this */
/** @var app\models\ProdukteSearch $searchModel */
/** @var yii\data\ActiveDataProvider $dataProvider */
/** @var app\models\Produkte $produkte array[] */
/** @var app\models\Produkte $produkt array[] */

$this->title = Yii::t('app', 'Produktes');
$this->params['breadcrumbs'][] = $this->title;
?>body
<div class="produkte-index">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a(Yii::t('app', 'Create Produkte'), ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?php
    $models = array_slice($dataProvider->getModels(), 0);
    if (!empty($models)): ?>
        <div class="row g-4 mb-4">
            <?php foreach ($models as $model): ?>
                <div class="col-12 col-sm-6 col-lg-4 col-xl-3">
                        <div class="card h-100">
                        <div class="card-body d-flex flex-column">
                            <p class="card-header text-muted">Lieferant: <?= Html::encode($model->lieferanten->Lieferantenname) ?></p>
                            <div class="card-body">
                                <h4 class="card-text"><?= Html::encode($model->Produktname) ?></h4>
                                <p class="card-text mb-1"><strong>Kategorie:</strong> <?= Html::encode($model->Produktkategorie) ?></p>
                                <p class="card-text mb-2"><strong>Preis:</strong> <?= Html::encode($model->Stueckpreis) ?></p>
                            </div>
                            <div class="card-footer mt-auto">
                                <?= Html::a(Yii::t('app', 'View'), ['view', 'ProduktID' => $model->ProduktID], ['class' => 'btn btn-primary me-2']) ?>
                                <?= Html::a(Yii::t('app', 'Edit'), ['update', 'ProduktID' => $model->ProduktID], ['class' => 'btn btn-secondary me-2']) ?>
                                <?= Html::a(Yii::t('app', 'Delete'), ['delete', 'ProduktID' => $model->ProduktID], ['class' => 'btn btn-danger']) ?>
                            </div>
                        </div>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>
    <?php endif; ?>

    <?php Pjax::begin(); ?>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <?= GridView::widget([
            'dataProvider' => $dataProvider,
            'filterModel' => $searchModel,
            'columns' => [
                    ['class' => 'yii\grid\SerialColumn'],

                    'ProduktID',
                    'Produktname',
                    'Produktkategorie',
                    'Stueckpreis',
                    'LieferantenID',
                    [
                            'class' => ActionColumn::className(),
                            'urlCreator' => function ($action, Produkte $model, $key, $index, $column) {
                                return Url::toRoute([$action, 'ProduktID' => $model->ProduktID]);
                            }
                    ],
            ],
    ]); ?>

    <?php Pjax::end(); ?>

</div>
